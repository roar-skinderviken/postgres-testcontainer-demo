package no.javatec.demo.repository

import io.micronaut.core.annotation.Introspected
import io.micronaut.data.annotation.DateCreated
import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "my_test_table")
@Introspected
data class TestEntity(

    @Id
    val id: UUID = UUID.randomUUID(),

    @Column(name = "message", columnDefinition = "varchar(255)", nullable = false)
    val message: String? = null,

    @DateCreated
    @Column(nullable = false)
    var created: ZonedDateTime? = null
)