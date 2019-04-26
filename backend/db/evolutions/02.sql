# --- !Ups

-------------------------- USUARIO --------------------------     
CREATE TABLE IF NOT EXISTS sigesdp.usuario (
    id_usuario SERIAL NOT NULL,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(64) NOT NULL,
    PRIMARY KEY (id_usuario)
);

-------------------------- COMENTARIOS -------------------------- 
COMMENT ON TABLE sigesdp.usuario IS 'Entidade responsável por armazenar os usuários do sistema.';
COMMENT ON COLUMN sigesdp.usuario.id_usuario IS 'Identificador único do usuário.';
COMMENT ON COLUMN sigesdp.usuario.nome IS 'Nome do usuário.';
COMMENT ON COLUMN sigesdp.usuario.email IS 'E-mail do usuário.';
COMMENT ON COLUMN sigesdp.usuario.senha IS 'Senha do usuário.';

-------------------------- GRANTS AND SEQUENCES --------------------------
GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE sigesdp.usuario TO sigesdp_pa;
ALTER TABLE sigesdp.usuario OWNER TO postgres;


# --- !Downs

DROP TABLE IF EXISTS sigesdp.usuario;