--create databases

CREATE DATABASE lessons5;


-- create table


CREATE TABLE public.task
(
    id uuid NOT NULL,
    status character varying(255) COLLATE pg_catalog."default",
    "timestamp" timestamp without time zone,
    CONSTRAINT task_pkey PRIMARY KEY (id)
)