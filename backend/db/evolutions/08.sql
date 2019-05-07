# --- !Ups

-------------------------- GRUPO_PESQUISA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.grupo_pesquisa (
    id SERIAL NOT NULL,
    grupo_pesquisa TEXT NOT NULL,
    id_professor INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_id_professor_grupo_pesquisa FOREIGN KEY(id_professor) REFERENCES sigesdp.professor (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.grupo_pesquisa IS 'Entidade responsável por armazenar os grupos de pesquisa do sistema.';
COMMENT ON COLUMN sigesdp.grupo_pesquisa.id IS 'Identificador único do grupo de pesquisa.';
COMMENT ON COLUMN sigesdp.grupo_pesquisa.grupo_pesquisa IS 'Grupo de pesquisa.';
COMMENT ON COLUMN sigesdp.grupo_pesquisa.id_professor IS 'Identificador do grupo de pesquisa do professor.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.grupo_pesquisa TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.grupo_pesquisa_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.grupo_pesquisa OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.grupo_pesquisa;