# --- !Ups

-------------------------- AREA_CONHECIMENTO --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.area_conhecimento (
    id SERIAL NOT NULL,
    area_conhecimento TEXT NOT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.area_conhecimento IS 'Entidade responsável por armazenar as área de conhecimento dos projetos do sistema.';
COMMENT ON COLUMN sigesdp.area_conhecimento.id IS 'Identificador único da área de conhecimento.';
COMMENT ON COLUMN sigesdp.area_conhecimento.area_conhecimento IS 'Área de conhecimento.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.area_conhecimento TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.area_conhecimento_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.area_conhecimento OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.area_conhecimento;