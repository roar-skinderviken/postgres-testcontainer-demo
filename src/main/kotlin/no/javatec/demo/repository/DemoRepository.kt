package no.javatec.demo.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository
import java.util.UUID

@Repository
interface DemoRepository : CrudRepository<DemoEntity, UUID> {
}