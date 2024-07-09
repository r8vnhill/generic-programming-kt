package cl.ravenhill.sorting

/**
 * Sorts a list using the quicksort algorithm and a custom comparator.
 *
 * ## Usage:
 * This function sorts a list of elements using the quicksort algorithm. It takes a custom comparator to determine the
 * order of the elements.
 *
 * ### Example 1: Sorting a List of Integers in Ascending Order
 * ```
 * val list = listOf(3, 6, 1, 8, 4, 5)
 * val sortedList = quickSort(list, Comparator { a, b -> a - b })
 * println(sortedList) // Output: [1, 3, 4, 5, 6, 8]
 * ```
 *
 * ### Example 2: Sorting a List of Strings by Length
 * ```
 * val list = listOf("apple", "banana", "kiwi", "cherry")
 * val sortedList = quickSort(list, Comparator { a, b -> a.length - b.length })
 * println(sortedList) // Output: [kiwi, apple, banana, cherry]
 * ```
 *
 * @param T The type of elements in the list.
 * @param list The list to be sorted.
 * @param comparator The comparator used to determine the order of the elements.
 * @return A new list with the elements sorted.
 */
fun <T> quickSort(list: List<T>, comparator: Comparator<T>): List<T> {
    // Base case: If the list has less than 2 elements, it is already sorted.
    if (list.size < 2) return list

    // Select the pivot element from the middle of the list.
    val pivot = list[list.size / 2]

    // Use a fold operation to partition the list into three parts:
    // less: elements less than the pivot
    // equal: elements equal to the pivot
    // greater: elements greater than the pivot
    val (less, equal, greater) = list.fold(
        Triple(
            mutableListOf<T>(), // Initialize the 'less' list
            mutableListOf<T>(), // Initialize the 'equal' list
            mutableListOf<T>()  // Initialize the 'greater' list
        )
    ) { acc, item ->
        when {
            // Add the item to the 'less' list if it is less than the pivot
            comparator.compare(item, pivot) < 0 -> acc.first.add(item)
            // Add the item to the 'equal' list if it is equal to the pivot
            comparator.compare(item, pivot) == 0 -> acc.second.add(item)
            // Add the item to the 'greater' list if it is greater than the pivot
            else -> acc.third.add(item)
        }
        acc // Return the accumulator for the next iteration
    }

    // Recursively sort the 'less' and 'greater' lists and concatenate them with the 'equal' list
    return quickSort(less, comparator) + equal + quickSort(greater, comparator)
}

fun main() {
    val list = listOf(3, 1, 4, 1, 5, 9)
    val sortedList = quickSort(list, Comparator.naturalOrder())
    println(sortedList) // Output: [1, 1, 3, 4, 5, 9]
}
