# --- !Ups

-------------------------- MODALIDADE_BOLSA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.modalidade_bolsa (
    id_modalidade SERIAL NOT NULL,
    modalidade VARCHAR(80) NOT NULL,
    PRIMARY KEY (id_modalidade)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.modalidade_bolsa IS 'Entidade responsável por armazenar os tipos de modalidade de bolsa do sistema.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.id_modalidade IS 'Identificador único da modalidade de bolsa de pesquisa.';
COMMENT ON COLUMN sigesdp.modalidade_bolsa.modalidade IS 'Tipo de modalidade da bolsa.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.modalidade_bolsa TO sigesdp_pa;
ALTER TABLE sigesdp.modalidade_bolsa OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.modalidade_bolsa;