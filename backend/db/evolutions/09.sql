# --- !Ups

-------------------------- CURSO --------------------------
CREATE TABLE IF NOT EXISTS sigesdp.curso (
    id_curso SERIAL NOT NULL,
    nome_curso VARCHAR(100) NOT NULL,
    id_departamento INTEGER NOT NULL,
    PRIMARY KEY (id_curso),
    CONSTRAINT fk_id_departamento_curso FOREIGN KEY (id_departamento) REFERENCES sigesdp.departamento (id_departamento)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.curso IS 'Entidade responsável por armazenar os cursos do sistema.';
COMMENT ON COLUMN sigesdp.curso.id_curso IS 'Identificador único do curso.';
COMMENT ON COLUMN sigesdp.curso.nome_curso IS 'Nome do curso.';
COMMENT ON COLUMN sigesdp.curso.id_departamento IS 'Identificador do departamento que o curso pertence.';


-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.curso TO sigesdp_pa;
ALTER TABLE sigesdp.curso OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.curso;