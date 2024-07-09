package cl.ravenhill.library.books

/**
 * Interface representing a book with a title.
 *
 * ## Usage:
 * This interface defines the contract for a book, requiring implementations to provide a title.
 *
 * ### Example 1: Implementing the Book Interface
 * ```
 * class Novel(override val title: String) : Book
 *
 * val novel = Novel("The Two Towers")
 * println(novel.title) // Output: The Two Towers
 * ```
 * @property title The title of the book.
 */
interface Book {
    val title: String
}
