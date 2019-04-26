# --- !Ups

-------------------------- INSERINDO CURSOS --------------------------
INSERT INTO sigesdp.curso(nome_curso, id_departamento) VALUES ('Sistemas de Informação', 1);
INSERT INTO sigesdp.curso(nome_curso, id_departamento) VALUES ('Ciência da Computação', 1);
INSERT INTO sigesdp.curso(nome_curso, id_departamento) VALUES ('ABI – Engenharias', 7);
INSERT INTO sigesdp.curso(nome_curso, id_departamento) VALUES ('Administração', 2);

# --- !Downs

DELETE FROM sigesdp.curso WHERE nome_curso = 'Sistemas de Informação';
DELETE FROM sigesdp.curso WHERE nome_curso = 'Ciência da Computação';
DELETE FROM sigesdp.curso WHERE nome_curso = 'ABI – Engenharias';
DELETE FROM sigesdp.curso WHERE nome_curso = 'Administração';