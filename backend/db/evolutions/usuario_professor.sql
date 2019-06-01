# --- !Ups

-------------------------- INSERINDO USUARIO E PROFESSOR --------------------------
INSERT INTO sigesdp.usuario(email, senha) VALUES ('hemersonel@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3');
INSERT INTO sigesdp.professor(nome, curriculo_lates, formacao_academica, sala, telefone, id_departamento, id_usuario, id_area_conhecimento)
    VALUES ('Hemerson Batista', 'https://github.com/HemersonGH/', 'Bacharel em Sistemas de Informação', 'Sala 101 - 1º Andar', '(35) 9999-9999', 1, 1, 8);

INSERT INTO sigesdp.usuario(email, senha) VALUES ('phelipebatista@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3');
INSERT INTO sigesdp.professor(nome, curriculo_lates, formacao_academica, sala, telefone, id_departamento, id_usuario, id_area_conhecimento)
    VALUES ('Phelipe Batista', 'https://github.com/PhelipeBS/', 'Bacharel em Sistemas de Informação', 'Sala 201 - 2º Andar', '(35) 9999-9999', 1, 2, 3);

INSERT INTO sigesdp.usuario(email, senha) VALUES ('thalesbatista@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3');
INSERT INTO sigesdp.professor(nome, curriculo_lates, formacao_academica, sala, telefone, id_departamento, id_usuario, id_area_conhecimento)
    VALUES ('Thales Batista', 'https://github.com/ThalesBB/', 'Bacharel em Sistemas de Informação', 'Sala 301 - 3º Andar', '(35) 9999-9999', 2, 3, 5);

-- Senha = SigesdpDCC + String

# --- !Downs

DELETE FROM sigesdp.professor WHERE nome = 'Hemerson Batista';
DELETE FROM sigesdp.usuario WHERE email = 'hemersonel@gmail.com';

DELETE FROM sigesdp.professor WHERE nome = 'Phelipe Batista';
DELETE FROM sigesdp.usuario WHERE email = 'phelipebatista@gmail.com';

DELETE FROM sigesdp.professor WHERE nome = 'Thales Batista';
DELETE FROM sigesdp.usuario WHERE email = 'thalesbatista@gmail.com';