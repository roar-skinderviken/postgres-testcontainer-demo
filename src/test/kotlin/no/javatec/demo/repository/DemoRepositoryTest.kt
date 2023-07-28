package no.javatec.demo.repository

import io.kotest.assertions.asClue
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest
import jakarta.persistence.EntityManager
import no.javatec.demo.BehaviorCleanDbSpec

@MicronautTest
class DemoRepositoryTest(
    sut: DemoRepository,
    entityManager: EntityManager
) : BehaviorCleanDbSpec({

    Given("test entity") {
        val entityInTest = DemoEntity(message = "Hello World!")

        When("persist entityInTest") {
            entityManager.persist(entityInTest)

            Then("db should be as expected") {
                "sut should return count of 1".asClue {
                    sut.count().shouldBe(1)
                }

                "and it should be entityInTest".asClue {
                    sut.findAll().first().shouldBe(entityInTest)
                }
            }
        }
    }

    Given("empty database") {
        val entityInTest = DemoEntity(message = "Hello World 2!")

        When("save entityInTest") {
            sut.save(entityInTest)

            Then("db should be as expected") {
                val entitiesInDB = entityManager.createQuery(
                    "SELECT e FROM DemoEntity e",
                    DemoEntity::class.java
                ).resultList

                "there should be one entity in db".asClue {
                    entitiesInDB.size.shouldBe(1)
                }

                "and it should be entityInTest".asClue {
                    entitiesInDB.first().shouldBe(entityInTest)
                }
            }
        }
    }
})