# --- !Ups

-------------------------- DEPARTAMENTO -------------------------- 
CREATE TABLE IF NOT EXISTS sigesdp.departamento (
    id SERIAL NOT NULL,
    nome VARCHAR(150) NOT NULL,
    chefe VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    sigla VARCHAR(5) NOT NULL,
    descricao TEXT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.departamento IS 'Entidade responsável por armazenar os departamento do sistema.';
COMMENT ON COLUMN sigesdp.departamento.id IS 'Identificador único do departamento.';
COMMENT ON COLUMN sigesdp.departamento.nome IS 'Nome do departamento.';
COMMENT ON COLUMN sigesdp.departamento.chefe IS 'Nome do chefe do departamento.';
COMMENT ON COLUMN sigesdp.departamento.telefone IS 'Telefone do departamento.';
COMMENT ON COLUMN sigesdp.departamento.sigla IS 'Sigla do departamento.';
COMMENT ON COLUMN sigesdp.departamento.descricao IS 'Descricao do departamento.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.departamento TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.departamento_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.departamento OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.departamento;