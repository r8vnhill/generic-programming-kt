package cl.ravenhill.repo

class Repository<T> where T : Entity,
                          T : Serializable {
    private val _entities: MutableList<T> = mutableListOf()
    val entities: List<T> = _entities

    fun save(entity: T) {
        _entities += entity
    }

    fun serializeAll() = entities
        .joinToString(prefix = "[", postfix = "]") {
            it.serialize()
        }
}
