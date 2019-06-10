# --- !Ups

-------------------------- REMOVENDO COLUNAS DA TABELA PROJETO_PESQUISA --------------------------
ALTER TABLE sigesdp.projeto_pesquisa DROP COLUMN id_area_conhecimento;
ALTER TABLE sigesdp.projeto_pesquisa DROP COLUMN id_grupo_pesquisa;
ALTER TABLE sigesdp.projeto_pesquisa DROP COLUMN id_modalidade_bolsa;


# --- !Downs
ALTER TABLE sigesdp.projeto_pesquisa ADD COLUMN id_area_conhecimento integer NOT NULL;
ALTER TABLE sigesdp.projeto_pesquisa ADD COLUMN id_grupo_pesquisa integer NOT NULL;
ALTER TABLE sigesdp.projeto_pesquisa ADD COLUMN id_modalidade_bolsa integer NOT NULL;

CONSTRAINT fk_projeto_pesquisa_area_conhecimento FOREIGN KEY (id_area_conhecimento) REFERENCES sigesdp.area_conhecimento (id);
CONSTRAINT fk_projeto_pesquisa_modalidade_bolsa FOREIGN KEY (id_modalidade_bolsa) REFERENCES sigesdp.modalidade_bolsa (id);
CONSTRAINT fk_projeto_pesquisa_grupo_pesquisa FOREIGN KEY (id_grupo_pesquisa) REFERENCES sigesdp.grupo_pesquisa (id);

COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_grupo_pesquisa IS 'Identificador do grupo de pesquisa do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_area_conhecimento IS 'Identificador da area do conhecimento do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_modalidade_bolsa IS 'Identificador da modalidade da bolsa do projeto de pesquisa.';
