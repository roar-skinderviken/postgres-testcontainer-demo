package no.javatec.demo

import io.kotest.core.config.AbstractProjectConfig
import io.micronaut.test.extensions.kotest5.MicronautKotest5Extension

@Suppress("unused")
object ProjectConfig : AbstractProjectConfig() {
    override fun extensions() = listOf(MicronautKotest5Extension)

    override suspend fun beforeProject() {
        DbTestContainer.start()
    }

    override suspend fun afterProject() {
        DbTestContainer.stop()
    }
}
