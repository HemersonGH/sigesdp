# --- !Ups

-------------------------- MODALIDADE_BOLSA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.modalidade_bolsa (
    id SERIAL NOT NULL,
    nome VARCHAR(200) NOT NULL,
    sigla VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.modalidade_bolsa IS 'Entidade responsável por armazenar as modalidades de bolsa do sistema.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.id IS 'Identificador único da modalidade dd bolsa do projeto pesquisa.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.nome IS 'Nome da modalidade da bolsa.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.sigla IS 'Sigla da modalidade da bolsa.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.modalidade_bolsa TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.modalidade_bolsa_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.modalidade_bolsa OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.modalidade_bolsa;