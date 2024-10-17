package cl.ravenhill.generics

/**
 * Returns the input value unchanged.
 *
 * The `identity` function is a simple generic function that takes a value of any type `T` and returns it as-is,
 * without modification. This function is commonly used in functional programming as a no-op or placeholder function.
 *
 * ## Usage:
 * The `identity` function can be used in contexts where a function is required but no transformation or action is
 * needed on the value.
 *
 * ### Example 1: Using the `identity` Function
 * ```kotlin
 * val value = 42
 * val result = identity(value)
 * println(result) // Outputs: 42
 * ```
 *
 * ### Example 2: Using `identity` with Different Types
 * ```kotlin
 * val stringValue = identity("Hello")
 * val intValue = identity(100)
 * println(stringValue) // Outputs: Hello
 * println(intValue) // Outputs: 100
 * ```
 *
 * @param T The type of the input value.
 * @param value The input value to be returned.
 * @return The input value unchanged.
 */
fun <T> identity(value: T) = value
