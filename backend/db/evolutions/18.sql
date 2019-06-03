# --- !Ups

-------------------------- INSERINDO MODALIDADES DE BOLSA --------------------------
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Bolsa de Iniciação Científica Junior', 'BICJR (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Jovens Talentos', 'Jovens Talentos (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação Científica - CNPq', 'PIBIC/CNPq (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação Científica - FAPEMIG', 'PIBIC/FAPEMIG (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação Científica - PROMEC', 'PIBIC/PROMEC (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação Científica - UFLA', 'PIBIC/UFLA (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação Científica - UFLA-AC', 'PIBIC/UFLA-AC (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Programa Institucional de Bolsas de Iniciação em Desenvolvimento Tecnológico e Inovação - CNPq', 'PIBITI/CNPq (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Projeto de Pesquisa de Iniciação Científica Voluntária', 'PIVIC (IC)');
INSERT INTO sigesdp.modalidade_bolsa(nome, sigla) VALUES ('Voluntário', 'Voluntário (IC)');

# --- !Downs

DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'BICJR (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'Jovens Talentos (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBIC/CNPq (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBIC/FAPEMIG (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBIC/PROMEC (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBIC/UFLA (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBIC/UFLA-AC (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIBITI/CNPq (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'PIVIC (IC)';
DELETE FROM sigesdp.modalidade_bolsa WHERE sigla = 'Voluntário (IC)';