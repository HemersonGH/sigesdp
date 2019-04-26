# --- !Ups

-------------------------- REL_PROF_ALUNO --------------------------    
CREATE TABLE IF NOT EXISTS sigesdp.rel_prof_aluno (
    id_professor INTEGER NOT NULL,
    id_aluno INTEGER NOT NULL,
    PRIMARY KEY (id_professor, id_aluno),
    CONSTRAINT fk_professor_has_aluno_professor FOREIGN KEY (id_professor) REFERENCES sigesdp.professor(id),
    CONSTRAINT fk_professor_has_aluno_aluno FOREIGN KEY (id_aluno) REFERENCES sigesdp.aluno (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.rel_prof_aluno IS 'Entidade responsável por armazenar relacionamento entre professores e alunos do sistema.';
COMMENT ON COLUMN sigesdp.rel_prof_aluno.id_professor IS 'Identificador do professor que orienta o aluno.';
COMMENT ON COLUMN sigesdp.rel_prof_aluno.id_aluno IS 'Identificador do aluno.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.rel_prof_aluno TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.rel_prof_aluno_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.rel_prof_aluno OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.rel_prof_aluno;
