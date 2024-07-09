package cl.ravenhill.library.books

/**
 * Represents a novel with a title.
 *
 * ## Usage:
 * This data class implements the [Book] interface and provides a simple representation of a novel with a title.
 *
 * ### Example 1: Creating and Using a Novel
 * ```
 * val novel = Novel("At the Mountains of Madness")
 * println(novel.title) // Output: At the Mountains of Madness
 * ```
 * @property title The title of the novel.
 */
data class Novel(override val title: String) : Book
