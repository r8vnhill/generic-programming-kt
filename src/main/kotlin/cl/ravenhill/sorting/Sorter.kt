package cl.ravenhill.sorting

/**
 * A generic sorter class that provides sorting algorithms for lists.
 *
 * ## Usage:
 * This class provides methods to sort a list using the quicksort and mergesort algorithms. It uses a custom comparator
 * to determine the order of the elements.
 *
 * ### Example 1: Using quickSort to Sort a List of Integers in Ascending Order
 * ```
 * val sorter = Sorter<Int>()
 * val list = listOf(3, 6, 1, 8, 4, 5)
 * val sortedList = sorter.quickSort(list, Comparator { a, b -> a - b })
 * println(sortedList) // Output: [1, 3, 4, 5, 6, 8]
 * ```
 *
 * ### Example 2: Using mergeSort to Sort a List of Strings by Length
 * ```
 * val sorter = Sorter<String>()
 * val list = listOf("apple", "banana", "kiwi", "cherry")
 * val sortedList = sorter.mergeSort(list, Comparator { a, b -> a.length - b.length })
 * println(sortedList) // Output: [kiwi, apple, banana, cherry]
 * ```
 *
 * @param T The type of elements in the list.
 */
class Sorter<T> {
    /**
     * Sorts a list using the quicksort algorithm and a custom comparator.
     *
     * ## Usage:
     * This method sorts a list of elements using the quicksort algorithm. It takes a custom comparator to determine the
     * order of the elements.
     *
     * ### Example 1: Sorting a List of Integers in Ascending Order
     * ```
     * val sorter = Sorter<Int>()
     * val list = listOf(3, 6, 1, 8, 4, 5)
     * val sortedList = sorter.quickSort(list, Comparator { a, b -> a - b })
     * println(sortedList) // Output: [1, 3, 4, 5, 6, 8]
     * ```
     *
     * @param list The list to be sorted.
     * @param comparator The comparator used to determine the order of the elements.
     * @return A new list with the elements sorted.
     */
    @Suppress("DuplicatedCode") // Duplicated code is used to keep the code snippets self-contained
    fun quickSort(list: List<T>, comparator: Comparator<T>): List<T> {
        if (list.size < 2) return list
        val pivot = list[list.size / 2]
        val (less, equal, greater) = list.fold(
            Triple(
                mutableListOf<T>(),
                mutableListOf<T>(),
                mutableListOf<T>()
            )
        ) { acc, item ->
            when {
                comparator.compare(item, pivot) < 0 -> acc.first.add(item)
                comparator.compare(item, pivot) == 0 -> acc.second.add(item)
                else -> acc.third.add(item)
            }
            acc
        }
        return quickSort(less, comparator) + equal + quickSort(greater, comparator)
    }

    /**
     * Sorts a list using the mergesort algorithm and a custom comparator.
     *
     * ## Usage:
     * This method sorts a list of elements using the mergesort algorithm. It takes a custom comparator to determine the
     * order of the elements.
     *
     * ### Example 1: Sorting a List of Strings by Length
     * ```
     * val sorter = Sorter<String>()
     * val list = listOf("apple", "banana", "kiwi", "cherry")
     * val sortedList = sorter.mergeSort(list, Comparator { a, b -> a.length - b.length })
     * println(sortedList) // Output: [kiwi, apple, banana, cherry]
     * ```
     *
     * @param list The list to be sorted.
     * @param comparator The comparator used to determine the order of the elements.
     * @return A new list with the elements sorted.
     */
    fun <T> mergeSort(list: List<T>, comparator: Comparator<T>): List<T> {
        if (list.size < 2) return list

        val middle = list.size / 2
        val (left, right) = list.partition { list.indexOf(it) < middle }

        return merge(mergeSort(left, comparator), mergeSort(right, comparator), comparator)
    }

    /**
     * Merges two sorted lists into a single sorted list.
     *
     * ## Usage:
     * This method merges two sorted lists into a single sorted list using a custom comparator.
     *
     * ### Example 1: Merging Two Sorted Lists of Integers
     * ```
     * val left = listOf(1, 3, 5)
     * val right = listOf(2, 4, 6)
     * val mergedList = merge(left, right, Comparator { a, b -> a - b })
     * println(mergedList) // Output: [1, 2, 3, 4, 5, 6]
     * ```
     *
     * @param left The left sorted list.
     * @param right The right sorted list.
     * @param comparator The comparator used to determine the order of the elements.
     * @return A new list with the elements merged and sorted.
     */
    private fun <T> merge(left: List<T>, right: List<T>, comparator: Comparator<T>): List<T> = when {
        left.isEmpty() -> right
        right.isEmpty() -> left
        comparator.compare(left.first(), right.first()) <= 0 ->
            listOf(left.first()) + merge(left.drop(1), right, comparator)
        else ->
            listOf(right.first()) + merge(left, right.drop(1), comparator)
    }
}
