package no.javatec.demo.repository

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.DateCreated
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.ZonedDateTime
import java.util.UUID

@Entity
@Table(name = "my_test_table")
@Introspected
data class DemoEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(name = "message", columnDefinition = "varchar(255)", nullable = false)
    val message: String? = null,

    @DateCreated
    @Column(nullable = false)
    var created: ZonedDateTime? = null
)