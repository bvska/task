create table task
(
    id        uuid not null
        constraint task_pkey
            primary key,
    status    varchar(255),
    timestamp timestamp
);

comment on table task is 'test';

alter table task
    owner to postgres;