INSERT INTO TB_ALUNO(nome, curso, idade, matricula) VALUES('Julio', 'Análise e desenvolvimento de sistemas', 21, true);
INSERT INTO TB_ALUNO(nome, curso, idade, matricula) VALUES('Henriky', 'Química', 23, false);
INSERT INTO TB_ALUNO(nome, curso, idade, matricula) VALUES('Vitor', 'Análise e desenvolvimento de sistemas', 25, false);

INSERT INTO TB_NOTA(nome_disciplina, nota, id_aluno) VALUES ('Banco de dados', 8.1, 1);
INSERT INTO TB_NOTA(nome_disciplina, nota, id_aluno) VALUES ('Programação web', 9.7, 1);
INSERT INTO TB_NOTA(nome_disciplina, nota, id_aluno) VALUES ('Inglês', 9.3, 1);

INSERT INTO TB_ENDERECO(rua, numero, cidade, estado, cep) VALUES('Rua 1', 123, 'São Paulo', 'SP', '12345-678');
INSERT INTO TB_ENDERECO(rua, numero, cidade, estado, cep) VALUES('Rua 2', 321, 'Rio de Janeiro', 'RJ', '98765-432');
INSERT INTO TB_ENDERECO(rua, numero, cidade, estado, cep) VALUES('Rua 3', 137, 'Poá', 'SP', '65432-987');

INSERT INTO TB_ALUNO_ENDERECO(id_aluno, id_endereco) VALUES(1, 1);
INSERT INTO TB_ALUNO_ENDERECO(id_aluno, id_endereco) VALUES(1, 3);
INSERT INTO TB_ALUNO_ENDERECO(id_aluno, id_endereco) VALUES(2, 2);
INSERT INTO TB_ALUNO_ENDERECO(id_aluno, id_endereco) VALUES(3, 2);