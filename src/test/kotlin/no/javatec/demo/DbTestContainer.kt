package no.javatec.demo

import org.testcontainers.containers.PostgreSQLContainer

object DbTestContainer {

    private lateinit var instance: PostgreSQLContainer<Nothing>

    fun start() {
        if (::instance.isInitialized) return

        instance = PostgreSQLContainer<Nothing>("postgres:14")
        instance.start()
        System.setProperty("datasources.default.url", instance.jdbcUrl)
        System.setProperty("datasources.default.username", instance.username)
        System.setProperty("datasources.default.password", instance.password)
    }

    fun stop() {
        instance.stop()
    }
}