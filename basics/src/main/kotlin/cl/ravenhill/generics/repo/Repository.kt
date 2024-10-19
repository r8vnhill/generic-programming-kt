package cl.ravenhill.generics.repo

interface Repository<T, K> {
    fun save(item: T)
    fun findByKey(key: K): T?
}