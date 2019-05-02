CREATE DATABASE quadratic
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'C'
    LC_CTYPE = 'C'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE SCHEMA public
    AUTHORIZATION postgres;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT ALL ON SCHEMA public TO postgres;

GRANT ALL ON SCHEMA public TO PUBLIC;

CREATE TABLE public."values"
(
    id bigint NOT NULL,
    a integer NOT NULL,
    b integer NOT NULL,
    c integer NOT NULL,
    x1 double precision NOT NULL,
    x2 double precision,
    CONSTRAINT values_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."values"
    OWNER to postgres;