-------------------------- CREATE ROLE --------------------------
CREATE ROLE sigesdp_dev LOGIN ENCRYPTED PASSWORD 'sigesdp' SUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION;
ALTER ROLE sigesdp SET search_path = sigesdp, public;