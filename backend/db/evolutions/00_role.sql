-------------------------- CREATE ROLE --------------------------
CREATE ROLE sigesdp_dev LOGIN ENCRYPTED PASSWORD 'sigesdp' SUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION;
ALTER ROLE sigesdp_dev SET search_path = sigesdp, public;

CREATE EXTENSION unaccent;