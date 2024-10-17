package cl.ravenhill.repo

interface Serializable {
    fun serialize(): String
    fun deserialize(serialized: String): Serializable
}
