package cl.ravenhill.generics.repo

class UserRepository : Repository<User, String> {
    private val users = mutableMapOf<String, User>()

    override fun save(item: User) {
        users[item.username] = item
    }

    override fun findByKey(key: String) = users[key]
}
