package cl.ravenhill.library.publications

import cl.ravenhill.library.Author
import cl.ravenhill.library.Authorable

/**
 * Represents a novel with a title.
 *
 * ## Usage:
 * This data class implements the [Publication] interface and provides a simple representation of a novel with a title
 * and an author.
 *
 * ### Example 1: Creating and Using a Novel
 * ```
 * val author = Author("H.P. Lovecraft")
 * val novel = Novel("At the Mountains of Madness", author)
 * println(novel.title) // Output: At the Mountains of Madness
 * ```
 * @property title The title of the novel.
 * @property author The author of the novel.
 */
data class Novel(override val title: String, override val author: Author<Novel>) : Publication, Authorable<Novel>
