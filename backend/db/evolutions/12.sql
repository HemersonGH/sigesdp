# --- !Ups

-------------------------- PROJETO_PESQUISA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.projeto_pesquisa (
    id SERIAL NOT NULL,
    titulo TEXT NOT NULL,
    data_inicio TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    data_termino TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    resumo TEXT NOT NULL,
    codigo_projeto VARCHAR(45) NOT NULL,
    grupo_pesquisa TEXT NOT NULL,
    id_area_conhecimento INTEGER NOT NULL,
    id_modalidade_bolsa INTEGER NOT NULL,
    id_anexo INTEGER NOT NULL,
    id_aluno INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_projeto_pesquisa_area_conhecimento FOREIGN KEY (id_area_conhecimento) REFERENCES sigesdp.area_conhecimento (id),
    CONSTRAINT fk_projeto_pesquisa_modalidade_bolsa FOREIGN KEY (id_modalidade_bolsa) REFERENCES sigesdp.modalidade_bolsa (id),
    CONSTRAINT fk_projeto_pesquisa_anexo FOREIGN KEY (id_anexo) REFERENCES sigesdp.anexo (id),
    CONSTRAINT fk_projeto_pesquisa_aluno FOREIGN KEY (id_aluno) REFERENCES sigesdp.aluno (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.projeto_pesquisa IS 'Entidade responsável por armazenar os pojetos de pesquisa do sistema.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id IS 'Identificador único do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.titulo IS 'Curriculo lates do professor.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.data_inicio IS 'Data de ínicio do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.data_termino IS 'Data de término do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.resumo IS 'Resumo do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.codigo_projeto IS 'Código do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.grupo_pesquisa IS 'Grupo do grupo de pesquisa do professor.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_area_conhecimento IS 'Identificador do departamento do professor.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_modalidade_bolsa IS 'Identificador do usuário do professor.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_anexo IS 'Identificador do usuário do professor.';
COMMENT ON COLUMN sigesdp.projeto_pesquisa.id_aluno IS 'Identificador do aluno do projeto de pesquisa.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.projeto_pesquisa TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.projeto_pesquisa_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.projeto_pesquisa OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.projeto_pesquisa;