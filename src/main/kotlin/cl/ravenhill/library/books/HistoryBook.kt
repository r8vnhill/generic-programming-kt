package cl.ravenhill.library.books

/**
 * Represents a history book with a title.
 *
 * ## Usage:
 * This data class implements the [Book] interface and provides a simple representation of a history book with a title.
 *
 * ### Example 1: Creating and Using a HistoryBook
 * ```
 * val historyBook = HistoryBook("El Chile Perplejo: Del Avanzar Sin Transar Al Transar Sin Parar")
 * println(historyBook.title) // Output: El Chile Perplejo: Del Avanzar Sin Transar Al Transar Sin Parar
 * ```
 * @property title The title of the history book.
 */
data class HistoryBook(override val title: String) : Book
