package no.javatec.demo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.test.TestCase
import io.micronaut.transaction.SynchronousTransactionManager
import io.micronaut.transaction.support.DefaultTransactionDefinition
import jakarta.inject.Inject
import javax.persistence.EntityManager

abstract class BehaviorCleanDbSpec(body: BehaviorSpec.() -> Unit = {}) : BehaviorSpec(body) {

    @Inject
    lateinit var entityManager: EntityManager

    @Inject
    lateinit var transactionManager: SynchronousTransactionManager<Any>

    override suspend fun beforeContainer(testCase: TestCase) {
        transactionManager.getTransaction(DefaultTransactionDefinition()).also { tx ->

            entityManager
                .createQuery("delete from DemoEntity")
                .executeUpdate()

            entityManager.clear()

            transactionManager.commit(tx)
        }
    }

    /**
     * Alternative to the above, using Flyway:
     * @Inject
     * lateinit var flyway: Flyway

     * override suspend fun afterTest(testCase: TestCase, result: TestResult) {
     *     flyway.clean()
     *     flyway.migrate()
     * }
     */
}
