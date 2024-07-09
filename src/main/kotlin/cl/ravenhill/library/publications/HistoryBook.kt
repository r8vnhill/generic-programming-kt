package cl.ravenhill.library.publications

import cl.ravenhill.library.Author
import cl.ravenhill.library.Authorable

/**
 * Represents a history book with a title.
 *
 * ## Usage:
 * This data class implements the [Publication] interface and provides a simple representation of a history book with a
 * title and an author.
 *
 * ### Example 1: Creating and Using a HistoryBook
 * ```
 * val jocelynHolt = Author("Alfredo Jocelyn-Holt")
 * val historyBook = HistoryBook(
 *     "El Chile Perplejo: Del Avanzar Sin Transar Al Transar Sin Parar",
 *     jocelynHolt
 * )
 * println(historyBook.title) // Output: El Chile Perplejo: Del Avanzar Sin Transar Al Transar Sin Parar
 * ```
 * @property title The title of the history book.
 * @property author The author of the history book.
 */
data class HistoryBook(override val title: String, override val author: Author<HistoryBook>) : Publication,
    Authorable<HistoryBook>
