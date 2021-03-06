# --- !Ups

-------------------------- DISCIPLINA --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.disciplina (
    id SERIAL NOT NULL,
    nome VARCHAR(150) NOT NULL,
    codigo_disciplina VARCHAR(10) NOT NULL,
    carga_horaria VARCHAR(45) NOT NULL,
    local VARCHAR(50) NOT NULL,
    horario VARCHAR(50) NOT NULL,
    id_professor INTEGER NOT NULL,
    id_departamento INTEGER NOT NULL,
    PRIMARY KEY (id, id_professor),
    CONSTRAINT fk_disciplina_professor FOREIGN KEY (id_professor) REFERENCES sigesdp.professor(id),
    CONSTRAINT fk_disciplina_departamento FOREIGN KEY (id_departamento) REFERENCES sigesdp.departamento (id)
);

-------------------------- COMENTARIOS --------------------------
COMMENT ON TABLE sigesdp.disciplina IS 'Entidade responsável por armazenar as disciplinas dos professores do sistema.';
COMMENT ON COLUMN sigesdp.disciplina.id IS 'Identificador único da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.nome IS 'Nome da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.codigo_disciplina IS 'Código de identificação da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.carga_horaria IS 'Carga horária da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.local IS 'Local da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.horario IS 'Horário da disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.id_professor IS 'Identificador do professor que responsável pela disciplina.';
COMMENT ON COLUMN sigesdp.disciplina.id_departamento IS 'Identificador do departamento da disciplina.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.disciplina TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.disciplina_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.disciplina OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.disciplina;