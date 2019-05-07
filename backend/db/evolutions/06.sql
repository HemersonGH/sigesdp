# --- !Ups

-------------------------- ANEXO --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.anexo (
    id SERIAL NOT NULL,
    caminho TEXT NOT NULL,
    nome TEXT NOT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.anexo IS 'Entidade responsável por armazenar os arquivos anexados nos projetos de pesquisa do sistema.';
COMMENT ON COLUMN sigesdp.anexo.id IS 'Identificador único do anexo do projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.anexo.caminho IS 'Caminho do arquivo anexado no projeto de pesquisa.';
COMMENT ON COLUMN sigesdp.anexo.nome IS 'Nome do arquivo anexado no projeto de pesquisa.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.anexo TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.anexo_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.anexo OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.anexo;