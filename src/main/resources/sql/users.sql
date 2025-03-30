CREATE TABLE IF NOT EXISTS public.users
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    login character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    is_admin boolean NOT NULL DEFAULT false,
    CONSTRAINT users_pkey PRIMARY KEY (id, login)
)

    TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;