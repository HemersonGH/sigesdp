# --- !Ups

-------------------------- MODALIDADE_BOLSA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.modalidade_bolsa (
    id SERIAL NOT NULL,
    modalidade VARCHAR(80) NOT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.modalidade_bolsa IS 'Entidade responsável por armazenar os tipos de modalidade de bolsa do sistema.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.id IS 'Identificador único da modalidade de bolsa de pesquisa.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.modalidade IS 'Tipo de modalidade da bolsa.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.modalidade_bolsa TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.modalidade_bolsa_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.modalidade_bolsa OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.modalidade_bolsa;