# --- !Ups

-------------------------- REMOVENDO COLUNA ID_ANEXO DA TABELA PROJETO_PESQUISA --------------------------
ALTER TABLE sigesdp.projeto_pesquisa DROP COLUMN id_anexo;

# --- !Downs

ALTER TABLE sigesdp.projeto_pesquisa ADD COLUMN id_anexo INTEGER NOT NULL CONSTRAINT fk_projeto_pesquisa_anexo REFERENCES sigesdp.anexo (id);
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_anexo IS 'Identificador único do anexo do projeto de pesquisa.';