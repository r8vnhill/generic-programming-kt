package cl.ravenhill.library

import cl.ravenhill.library.publications.Publication

/**
 * Interface representing an entity that can be authored.
 *
 * ## Usage:
 * This interface defines the contract for an entity that can be authored by an [Author]. The entity must be a subtype
 * of both [Publication] and [Authorable].
 *
 * ### Example 1: Implementing the Authorable Interface
 * ```
 * class MyBook(override val author: Author<MyBook>) : Publication, Authorable<MyBook>
 *
 * val author = Author<MyBook>("John Doe")
 * val myBook = MyBook(author)
 * println(myBook.author.name) // Output: John Doe
 * ```
 * @param B The type of the entity that can be authored, which must be a subtype of both [Publication] and [Authorable].
 * @property author The author of the entity.
 */
interface Authorable<B> where B : Publication, B : Authorable<B> {
    val author: Author<B>
}
