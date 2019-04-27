# --- !Ups

-------------------------- INSERINDO DEPARTAMENTOS --------------------------    
INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Ciência da Computação', 'Renato Ramos da Silva', '(35) 3829-1545', 'DCC', 
    'O DCC/UFLA é o principal responsável pelos cursos de Bacharelado em Ciência da Computação(BCC) e o Bacharelado em Sistemas de Informação (BSI) da UFLA.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Administração e Economia', 'Francisval de Melo Carvalho', '(35) 3829-1441', 'DAE', 
    'O Departamento de Administração e Economia esteve presente na história da UFLA desde os primeiros momentos em que começou a se configurar uma estrutura departamental, ainda na ESAL.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Ciências Exatas', 'Dr. Ulisses Azevedo Leitão', '(35) 3829-1961', 'DEX', 
    'O Departamento de Ciências Exatas (DEX) originou-se do DEG da UFLA e foi criado em 14 de março de 1973, inicialmente com a sigla DCE.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Direito', 'Isabela Dias Neves', '(35) 3829-4500', 'DIR', 
    'Desde suas raízes, com a criação da ESAL, em 1908, passando pela federalização promovida pela Lei nº 4.307, em 1963, e, finalmente, assumindo a condição de universidade pela Lei nº 8.956, em 1994, a UFLA se mostra vocacionada para o ensino e a pesquisa de excelência, além de comprometida com o desenvolvimento regional a partir de pioneira atuação extensionista.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Estatística', 'Júlio Sílvio de Sousa Bueno Filho', '(35) 3829-1965', 'DES', 
    'O departamento de estatística da Universidade Federal de Lavras (DES/UFLA) foi criado em agosto de 2016.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Física', 'Sergio Martins de Souza', '(35) 3829-5104', 'DFI', 
    'O departamento de física da UFLA foi criado em 2014. Atualmente  o departamento está hospedado no DEX, do qual fez parte até sua criação como um dos núcleos do departamento.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Engenharia', 'Carlos Eduardo Silva Volpato', '(35) 3829-1481', 'DEG', 
    'No ano de 1966 foi criado o Departamento de Engenharia Rural (DER), com sede Campus Histórico.'
);

INSERT INTO sigesdp.departamento(nome, chefe, telefone, sigla, descricao) 
    VALUES ('Departamento de Nutrição', 'Prof. Wilson César de Abreu', '(35) 3829-4692', 'DNU', 
    'O curso de Graduação em Nutrição da Universidade Federal de Lavras, UFLA, foi autorizado conforme Resolução CUNI n°005 de 04 de março de 2009.'
);

# --- !Downs

DELETE FROM sigesdp.departamento WHERE sigla = 'DCC';
DELETE FROM sigesdp.departamento WHERE sigla = 'DAE';
DELETE FROM sigesdp.departamento WHERE sigla = 'DEX';
DELETE FROM sigesdp.departamento WHERE sigla = 'DIR';
DELETE FROM sigesdp.departamento WHERE sigla = 'DES';
DELETE FROM sigesdp.departamento WHERE sigla = 'DFI';
DELETE FROM sigesdp.departamento WHERE sigla = 'DEG';
DELETE FROM sigesdp.departamento WHERE sigla = 'DNU';