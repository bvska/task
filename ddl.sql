-- CREATE TABLE task

    CREATE TABLE public.task
    (
        id uuid NOT NULL,
        status character varying(255) COLLATE pg_catalog."default",
        "timestamp" timestamp without time zone,
        CONSTRAINT task_pkey PRIMARY KEY (id)
    )

    TABLESPACE pg_default;

    ALTER TABLE public.task
        OWNER to postgres;