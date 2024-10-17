package cl.ravenhill.repo

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

private class MockEntity(override val id: Int) : Entity, Serializable {

    override fun serialize() = "MockEntity(id=$id)"

    override fun deserialize(serialized: String) = serialized
        .substringAfter("id=").toInt()
        .let(::MockEntity)
}

class RepositoryTest : FreeSpec({
    "A repository" - {
        "when saving an entity" - {
            "should contain the entity" {
                val repository = Repository<MockEntity>()
                val entity = MockEntity(1)
                with(repository) {
                    entities.shouldBeEmpty()
                    save(entity)
                    entities shouldHaveSize 1
                    entities.last() shouldBe entity
                    serializeAll() shouldBe "[MockEntity(id=1)]"
                }
            }
        }
    }
})
