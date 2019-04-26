# --- !Ups

CREATE ROLE sigesdp_pa LOGIN ENCRYPTED PASSWORD 'sigesdp' SUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION;
ALTER ROLE sigesdp SET search_path = sigesdp, public;

CREATE SCHEMA sigesdp;

ALTER SCHEMA sigesdp OWNER TO postgres;

-------------------------- GRANTS AND SEQUENCES --------------------------

GRANT USAGE ON SCHEMA sigesdp TO sigesdp_pa;
GRANT SELECT, USAGE ON ALL SEQUENCES IN SCHEMA sigesdp TO sigesdp_pa;
GRANT INSERT, SELECT, UPDATE, DELETE ON ALL TABLES IN SCHEMA sigesdp TO sigesdp_pa;

# --- !Downs

DROP SCHEMA sigesdp CASCADE;
