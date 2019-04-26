# --- !Ups

-------------------------- INSERINDO USUARIO E PROFESSOR --------------------------
INSERT INTO sigesdp.usuario(email, senha) VALUES ('hemersonel@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3');

INSERT INTO sigesdp.professor(curriculo_lates, area_interesse, formacao_academica, sala, telefone, id_departamento, id_usuario)
    VALUES ('https://github.com/HemersonGH/', 'Processos de Software', 'Bacharel em Sistemas de Informação', 'Sala 101 - 1º Andar', '(35) 9999-9999', 1, 1);

-- Senha = SigesdpDCC + String

# --- !Downs

DELETE FROM sigesdp.usuario WHERE email = 'hemersonel@gmail.com';
DELETE FROM sigesdp.professor WHERE nome = 'admin';