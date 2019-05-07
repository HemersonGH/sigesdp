# --- !Ups

-------------------------- USUARIO --------------------------     
CREATE TABLE IF NOT EXISTS sigesdp.usuario (
    id SERIAL NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(64) NOT NULL,
    PRIMARY KEY (id)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.usuario IS 'Entidade responsável por armazenar os usuários do sistema.';
COMMENT ON COLUMN sigesdp.usuario.id IS 'Identificador único do usuário.';
COMMENT ON COLUMN sigesdp.usuario.email IS 'E-mail do usuário.';
COMMENT ON COLUMN sigesdp.usuario.senha IS 'Senha do usuário.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.usuario TO sigesdp_dev;
GRANT SELECT, USAGE ON SEQUENCE sigesdp.usuario_id_seq TO sigesdp_dev;
ALTER TABLE sigesdp.usuario OWNER TO postgres;

# --- !Downs

DROP TABLE IF EXISTS sigesdp.usuario;