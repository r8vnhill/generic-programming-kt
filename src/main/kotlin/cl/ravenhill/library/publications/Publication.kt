package cl.ravenhill.library.publications

/**
 * Interface representing a book with a title.
 *
 * ## Usage:
 * This interface defines the contract for a book, requiring implementations to provide a title.
 *
 * ### Example 1: Implementing the Book Interface
 * ```
 * class BookImpl(override val title: String) : Book
 *
 * val book = BookImpl("The Two Towers")
 * println(book.title) // Output: The Two Towers
 * ```
 * @property title The title of the book.
 */
interface Publication {
    val title: String
}
