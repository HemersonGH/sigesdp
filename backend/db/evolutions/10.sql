# --- !Ups

-------------------------- ALUNO -------------------------- 
CREATE TABLE IF NOT EXISTS sigesdp.aluno (
    id_aluno SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    id_curso_aluno INTEGER NOT NULL,
    PRIMARY KEY (id_aluno),
    CONSTRAINT fk_aluno_curso FOREIGN KEY (id_curso_aluno) REFERENCES sigesdp.curso (id_curso)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.aluno IS 'Entidade responsável por armazenar os alunos dos projetos de pesquisa do sistema.';
COMMENT ON COLUMN sigesdp.aluno.id_aluno IS 'Identificador único do aluno.';
COMMENT ON COLUMN sigesdp.aluno.nome IS 'Nome do aluno.';
COMMENT ON COLUMN sigesdp.aluno.email IS 'Email do aluno.';
COMMENT ON COLUMN sigesdp.aluno.id_curso_aluno IS 'Identificador único do curso que o aluno realiza.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.aluno TO sigesdp_pa;
ALTER TABLE sigesdp.aluno OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.aluno;