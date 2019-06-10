# --- !Ups

-------------------------- ALTERANDO O NOME DA COLUNA CODIGO_PROJETO --------------------------
ALTER TABLE sigesdp.projeto_pesquisa RENAME COLUMN codigo_projeto TO codigo;

# --- !Downs

ALTER TABLE sigesdp.projeto_pesquisa RENAME COLUMN codigo TO codigo_projeto;