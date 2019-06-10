# --- !Ups

-------------------------- ALTERANDO O NOME DA COLUNA CURRICULO_LATTES --------------------------
ALTER TABLE sigesdp.professor RENAME COLUMN curriculo_lates TO curriculo_lattes;

# --- !Downs

ALTER TABLE sigesdp.professor RENAME COLUMN curriculo_lattes TO curriculo_lates;
