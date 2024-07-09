package cl.ravenhill.library

import cl.ravenhill.library.books.Book
import cl.ravenhill.library.books.HistoryBook
import cl.ravenhill.library.books.Novel

/**
 * Represents an author who writes books.
 *
 * ## Usage:
 * This class represents an author who writes books. The type of book is specified by the generic parameter `T`, which
 * must be a subtype of [Book].
 *
 * ### Example 1: Creating an Author and Writing a Book
 * ```
 * val author = Author<Novel>("Oscar Wilde")
 * val novel = Novel("The Canterville Ghost")
 * author.writeBook(novel)
 * // Output: Writing book: Novel(title=The Canterville Ghost)
 * ```
 *
 * ### Example 2: Creating an Author and Writing a History Book
 * ```
 * val author = Author<HistoryBook>("Eric Hobsbawm")
 * val historyBook = HistoryBook("The Age of Extremes")
 * author.writeBook(historyBook)
 * // Output: Writing book: HistoryBook(title=The Age of Extremes)
 * ```
 *
 * @param T The type of book the author writes, which must be a subtype of [Book].
 * @property name The name of the author.
 */
class Author<T>(val name: String) where T : Book {
    /**
     * Writes a book, printing the book's details.
     *
     * @param book The book to be written.
     */
    fun writeBook(book: T) = println("Writing book: $book")
}

fun main() {
    val garciaMarquez = Author<Book>("Gabriel García Márquez")
    val hobsbawm = Author<Book>("Eric Hobsbawm")
    val novel = Novel("One Hundred Years of Solitude")
    val historyBook = HistoryBook("The Age of Revolution")
    garciaMarquez.writeBook(novel)
    hobsbawm.writeBook(historyBook)
}
