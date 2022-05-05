create database movie_rental_store;

\c movie_rental_store;

create table movies_table
(
    id             integer not null
        constraint movies_table_pk
            primary key,
    title          varchar,
    category       varchar,
    main_character varchar,
    "description " varchar,
    date           varchar,
    price          integer
);

alter table movies_table
    owner to postgres;