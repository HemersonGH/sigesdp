-------------------------- CREATE ROLE --------------------------
CREATE ROLE sigesdp_dev LOGIN ENCRYPTED PASSWORD 'sigesdp' SUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION;
ALTER ROLE sigesdp SET search_path = sigesdp, public;

CREATE EXTENSION unaccent;

CREATE ROLE central_do_interessado_pa LOGIN
  ENCRYPTED PASSWORD 'central_do_interessado_pa'
  NOSUPERUSER INHERIT NOCREATEROLE NOREPLICATION;

ALTER ROLE central_do_interessado_pa
  SET search_path = central_do_interessado, public;
