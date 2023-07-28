# postgres-testcontainer-demo
Micronaut:4.x Kotlin-app using Postgres test container in Kotest.

### Run tests
```shell
./mvnw clean verify
```

### Misc
If you're adding your own `@Entity` annotated classes, don't forget to create tables in resources/db.migration/V01__create_tables.sql
