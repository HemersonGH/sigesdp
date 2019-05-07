# --- !Ups

CREATE SCHEMA sigesdp;

ALTER SCHEMA sigesdp OWNER TO postgres;

-------------------------- GRANTS AND SEQUENCES --------------------------

GRANT USAGE ON SCHEMA sigesdp TO sigesdp_dev;
GRANT SELECT, USAGE ON ALL SEQUENCES IN SCHEMA sigesdp TO sigesdp_dev;
GRANT INSERT, SELECT, UPDATE, DELETE ON ALL TABLES IN SCHEMA sigesdp TO sigesdp_dev;

# --- !Downs

DROP SCHEMA sigesdp CASCADE;
