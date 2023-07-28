package no.javatec.demo.repository

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
                sut.count() shouldBe 1
                sut.findById(entityInTest.id).get().message shouldBe "Hello World!"
            }
        }
    }
})