CREATE DATABASE test
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    
-- DROP TABLE public.datos;

CREATE TABLE public.datos
(
    correo text COLLATE pg_catalog."default",
    nombrecompleto text COLLATE pg_catalog."default",
    password text COLLATE pg_catalog."default",
    usuario text COLLATE pg_catalog."default"
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.datos
    OWNER to postgres;