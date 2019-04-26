# --- !Ups

-------------------------- PROFESSOR --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.professor (
    id_professor SERIAL NOT NULL,
    curriculo_lates TEXT NULL,
    area_interesse TEXT NULL,
    formacao_academica TEXT NULL,
    sala VARCHAR(50) NULL,
    telefone VARCHAR(20) NULL,
    id_departamento INTEGER NOT NULL,
    id_usuario INTEGER NOT NULL,
    PRIMARY KEY (id_professor),
    CONSTRAINT fk_id_departamento FOREIGN KEY(id_departamento) REFERENCES sigesdp.departamento (id_departamento),
    CONSTRAINT fk_id_usuario FOREIGN KEY(id_usuario) REFERENCES sigesdp.usuario (id_usuario)
);


-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.professor IS 'Entidade responsável por armazenar os professores do sistema.';
COMMENT ON COLUMN sigesdp.professor.id_professor IS 'Identificador único do professor.';
COMMENT ON COLUMN sigesdp.professor.curriculo_lates IS 'Curriculo lates do professor.';
COMMENT ON COLUMN sigesdp.professor.area_interesse IS 'Área de interesse do professor.';
COMMENT ON COLUMN sigesdp.professor.formacao_academica IS 'Formação acadêmica do professor.';
COMMENT ON COLUMN sigesdp.professor.sala IS 'Sala do professor.';
COMMENT ON COLUMN sigesdp.professor.telefone IS 'Telefone do professor.';
COMMENT ON COLUMN sigesdp.professor.id_departamento IS 'Identificador do departamento do professor.';
COMMENT ON COLUMN sigesdp.professor.id_usuario IS 'Identificador do usuário do professor.';


-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.professor TO sigesdp_pa;
ALTER TABLE sigesdp.professor OWNER TO postgres;


# --- !Downs

DROP TABLE IF EXISTS sigesdp.professor;