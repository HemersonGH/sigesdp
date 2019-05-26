# --- !Ups

-------------------------- ALTERANDO O NOME DA COLUNA CODIGO_DISCIPLINA --------------------------
ALTER TABLE sigesdp.disciplina RENAME COLUMN codigo_disciplina TO codigo;

# --- !Downs

ALTER TABLE sigesdp.disciplina RENAME COLUMN codigo TO codigo_disciplina;
