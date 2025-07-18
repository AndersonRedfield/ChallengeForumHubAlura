
INSERT INTO curso (nome) VALUES ('Spring');
INSERT INTO curso (nome) VALUES ('Spring Boot');
INSERT INTO curso (nome) VALUES ('Java');
INSERT INTO curso (nome) VALUES ('Security');
INSERT INTO usuario (login, senha) VALUES ('admin', '$2a$10$zkX4eOi2UuEoMKvFbslYWeAjMlQgbvGpU5uXH2lDWRUPn2RPTHcQC');
INSERT INTO usuario (login, senha) VALUES ('devuser', '$2a$10$zkX4eOi2UuEoMKvFbslYWeAjMlQgbvGpU5uXH2lDWRUPn2RPTHcQC');
INSERT INTO topico (titulo, mensagem, data_criacao, curso_id, autor_id)
VALUES ('Erro ao conectar no banco', 'Não consigo acessar o banco de dados MySQL', '2025-07-16T10:51:08.536', 1, 1);
INSERT INTO topico (titulo, mensagem, data_criacao, curso_id, autor_id)
VALUES ('Como configurar Spring Security?', 'Estou com dificuldades na autenticação JWT', '2025-07-16T11:01:22.366', 2, 2);