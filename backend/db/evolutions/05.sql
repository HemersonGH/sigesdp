# --- !Ups

-------------------------- AREA_CONHECIMENTO --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.area_conhecimento (
    id_area_conhecimento SERIAL NOT NULL,
    area_conhecimento TEXT NOT NULL,
    PRIMARY KEY (id_area_conhecimento)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.area_conhecimento IS 'Entidade responsável por armazenar as área de conhecimento dos projetos do sistema.';
COMMENT ON COLUMN sigesdp.area_conhecimento.id_area_conhecimento IS 'Identificador único da área de conhecimento.';
COMMENT ON COLUMN sigesdp.area_conhecimento.area_conhecimento IS 'Área de conhecimento.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.area_conhecimento TO sigesdp_pa;
ALTER TABLE sigesdp.area_conhecimento OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.area_conhecimento;