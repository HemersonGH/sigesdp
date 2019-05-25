# --- !Ups

-------------------------- INSERINDO COLUNA TIPO PARA A DISCIPLINA --------------------------
ALTER TABLE sigesdp.disciplina ADD COLUMN tipo INTEGER NOT NULL;
COMMENT ON COLUMN sigesdp.disciplina.tipo IS 'Identificador do tipo da disciplina.';

# --- !Downs

ALTER TABLE sigesdp.disciplina DROP COLUMN tipo;
