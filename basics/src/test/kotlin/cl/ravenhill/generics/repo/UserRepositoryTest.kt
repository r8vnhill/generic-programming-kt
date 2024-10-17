package cl.ravenhill.generics.repo

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.flatMap
import io.kotest.property.arbitrary.map
import io.kotest.property.arbs.name
import io.kotest.property.arbs.usernames
import io.kotest.property.checkAll

class UserRepositoryTest : FreeSpec({
    "A user repository" - {
        "when attempting to find a user by username" - {
            "should return the user if it was saved" {
                checkAll(arbUser()) { user ->
                    val repository = UserRepository()
                    repository.findByKey(user.username).shouldBeNull()
                    repository.save(user)
                    repository.findByKey(user.username)
                        .shouldNotBeNull()
                        .shouldBe(user)
                }
            }

            "should return null if the user was not saved" {
                checkAll(arbUser()) { user ->
                    val repository = UserRepository()
                    repository.findByKey(user.username).shouldBeNull()
                }
            }
        }
    }
})

private fun arbUser(): Arb<User> = Arb.name()
    .flatMap { name ->
        Arb.usernames().map { username ->
            User("$username", "$name")
        }
    }
