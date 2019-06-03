# --- !Ups

-------------------------- ALTERANDO O NOME DA COLUNA ID_CURSO_ALUNO --------------------------
ALTER TABLE sigesdp.aluno RENAME COLUMN id_curso_aluno TO id_curso;

# --- !Downs

ALTER TABLE sigesdp.aluno RENAME COLUMN id_curso TO id_curso_aluno;
