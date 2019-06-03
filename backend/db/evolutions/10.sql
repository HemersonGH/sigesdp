# --- !Ups

-------------------------- ALUNO -------------------------- 
CREATE TABLE IF NOT EXISTS sigesdp.aluno (
    id SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    id_professor INTEGER NOT NULL,
    id_curso_aluno INTEGER NOT NULL,
    id_modalidade_bolsa INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_professor FOREIGN KEY (id_professor) REFERENCES sigesdp.professor (id),
    CONSTRAINT fk_aluno_curso FOREIGN KEY (id_curso_aluno) REFERENCES sigesdp.curso (id),
    CONSTRAINT fk_aluno_modalidade_bolsa FOREIGN KEY (id_modalidade_bolsa) REFERENCES sigesdp.modalidade_bolsa (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.aluno IS 'Entidade responsável por armazenar os alunos dos projetos de pesquisa do sistema.';
COMMENT ON COLUMN sigesdp.aluno.id IS 'Identificador único do aluno.';
COMMENT ON COLUMN sigesdp.aluno.nome IS 'Nome do aluno.';
COMMENT ON COLUMN sigesdp.aluno.email IS 'Email do aluno.';
COMMENT ON COLUMN sigesdp.aluno.id_professor IS 'Identificador único do orientador do aluno.';
COMMENT ON COLUMN sigesdp.aluno.id_curso_aluno IS 'Identificador único do curso que o aluno realiza.';
COMMENT ON COLUMN sigesdp.aluno.id_modalidade_bolsa IS 'Identificador único da modalidade de bolsa do aluno.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.aluno TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.aluno_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.aluno OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.aluno;