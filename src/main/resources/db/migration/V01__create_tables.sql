drop table if exists my_test_table;

create table my_test_table
(
    id              uuid primary key,
    message         varchar(255) not null,
    created         timestamp    not null
);