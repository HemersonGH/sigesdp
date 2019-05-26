# --- !Ups

-------------------------- INSERINDO USUARIO E PROFESSOR --------------------------
INSERT INTO sigesdp.disciplina(nome, codigo, carga_horaria, local, horario, tipo, id_professor, id_departamento) VALUES 
	('Sistemas de informação', 'GCC152', '64', 'PV02 - Sala 201', '21:00', 0, 1, 1);
	
INSERT INTO sigesdp.disciplina(nome, codigo, carga_horaria, local, horario, tipo, id_professor, id_departamento) VALUES 
	('Introdução aos Algoritmos', 'GCC252', '64', 'PV03 - Sala 201', '19:00', 0, 1, 1);
	
INSERT INTO sigesdp.disciplina(nome, codigo, carga_horaria, local, horario, tipo, id_professor, id_departamento) VALUES 
	('Engenharia de Software', 'GCC118', '64', 'PV02 - Sala 201', '21:00', 1, 1, 1);
	
INSERT INTO sigesdp.disciplina(nome, codigo, carga_horaria, local, horario, tipo, id_professor, id_departamento) VALUES 
	('Redes de Computadores', 'GCC236', '64', 'PV06 - Sala 28', '17:00', 0, 1, 1);
	
INSERT INTO sigesdp.disciplina(nome, codigo, carga_horaria, local, horario, tipo, id_professor, id_departamento) VALUES 
	('Inteligência Artificial', 'GCC144', '64', 'PV02 - Sala 101', '17:00', 1, 1, 1);
  
  # --- !Downs
DELETE FROM sigesdp.disciplina WHERE codigo = 'GCC152';
DELETE FROM sigesdp.disciplina WHERE codigo = 'GCC252';
DELETE FROM sigesdp.disciplina WHERE codigo = 'GCC118';
DELETE FROM sigesdp.disciplina WHERE codigo = 'GCC236';
DELETE FROM sigesdp.disciplina WHERE codigo = 'GCC144';