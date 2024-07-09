package cl.ravenhill.library

import cl.ravenhill.library.publications.HistoryBook
import cl.ravenhill.library.publications.Novel
import cl.ravenhill.library.publications.Publication

/**
 * Represents an author who writes books.
 *
 * ## Usage:
 * This class represents an author who writes publications. The type of book is specified by the generic parameter `T`,
 * which must be a subtype of [Publication] and [Authorable]. The author can write a publication by calling the `write`
 * method, which prints a message to the console.
 *
 * ### Example 1: Creating an Author and Writing a Novel
 * ```
 * val author = Author<Novel>("Oscar Wilde")
 * val novel = Novel("The Canterville Ghost", author)
 * author.write(novel)
 * // Output: Writing: Novel(title=The Canterville Ghost)
 * ```
 *
 * ### Example 2: Creating an Author and Writing a History Book
 * ```
 * val author = Author<HistoryBook>("Eric Hobsbawm")
 * val historyBook = HistoryBook("The Age of Extremes", author)
 * author.writeBook(historyBook)
 * // Output: Writing: HistoryBook(title=The Age of Extremes)
 * ```
 *
 * @param T The type of book the author writes, which must be a subtype of [Publication].
 * @property name The name of the author.
 */
class Author<T>(val name: String) where T : Publication, T : Authorable<T> {
    /**
     * Writes a publication, printing a message to the console.
     *
     * @param publication The publication to write.
     */
    fun write(publication: T) = println("Writing: $publication")
}

fun main() {
    val garciaMarquez = Author<Novel>("Gabriel García Márquez")
    val hobsbawm = Author<HistoryBook>("Eric Hobsbawm")
    val novel = Novel("One Hundred Years of Solitude", garciaMarquez)
    val historyBook = HistoryBook("The Age of Revolution", hobsbawm)
    garciaMarquez.write(novel)
    hobsbawm.write(historyBook)
}
