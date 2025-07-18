

https://github.com/user-attachments/assets/f4957481-109e-47f8-a5cb-3c06755a76dc


# 📘 FórumHub — API REST em Spring Boot

**Desafio Back End Alura — FórumHub**

---

## 💬 Descrição do Projeto

O FórumHub é uma API REST desenvolvida em **Java com Spring Boot**, que simula o backend de um sistema de fórum de dúvidas semelhante ao da Alura. Essa API permite que usuários façam login e criem, leiam, atualizem e deletem tópicos relacionados a cursos.

A API possui:
- CRUD completo de tópicos
- Autenticação via **JWT**
- Validações
- Migrações com Flyway
- Integração com MySQL
- Integração com ferramentas como **Insomnia** e **Postman**

---

## ✅ Tecnologias e Dependências Utilizadas

| Tecnologia | Versão Recomendada |
|------------|--------------------|
| Java       | 17+                |
| Spring Boot| 3.x                |
| MySQL      | 8.x                |
| Flyway     | ✅                 |
| JWT (jjwt) | ✅                 |
| Maven      | ✅                 |
| Lombok     | ✅                 |

### 📦 Dependências (pom.xml)

```xml

	<dependencies>

		<dependency>
			<groupId>jakarta.persistence</groupId>
			<artifactId>jakarta.persistence-api</artifactId>
			<version>3.1.0</version>
		</dependency>

		<dependency>
			<groupId>jakarta.validation</groupId>
			<artifactId>jakarta.validation-api</artifactId>
			<version>3.0.2</version>
		</dependency>

		<dependency>
			<groupId>jakarta.annotation</groupId>
			<artifactId>jakarta.annotation-api</artifactId>
			<version>2.1.1</version>
		</dependency>

			<dependency>
				<groupId>io.jsonwebtoken</groupId>
				<artifactId>jjwt-api</artifactId>
				<version>${jjwt.version}</version>
			</dependency>

			<dependency>
				<groupId>io.jsonwebtoken</groupId>
				<artifactId>jjwt-impl</artifactId>
				<version>${jjwt.version}</version>
				<scope>runtime</scope>
			</dependency>
			<dependency>
				<groupId>io.jsonwebtoken</groupId>
				<artifactId>jjwt-jackson</artifactId>
				<version>${jjwt.version}</version>
				<scope>runtime</scope>
			</dependency>

		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.6.14</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-validation</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-core</artifactId>
		</dependency>

		<dependency>
			<groupId>org.flywaydb</groupId>
			<artifactId>flyway-mysql</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>

	</dependencies>

```

---

## ⚙️ Requisitos para Rodar o Projeto

- ✅ Java JDK 17+
- ✅ MySQL Server 8+
- ✅ IntelliJ IDEA (recomendado)
- ✅ Maven
- ✅ Insomnia ou Postman
- ✅ Git instalado

---

## 🛠️ Clonando o Projeto

```bash

git clone https://github.com/AndersonRedfield/ChallengeForumHubAlura.git
cd ChallengeForumHubAlura

```

---

## 🗄️ Configuração do Banco de Dados

### 🔸 Criar banco de dados manualmente

```sql
CREATE DATABASE forumhub CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 🔸 Criar usuário

```sql
CREATE USER 'forumuser'@'localhost' IDENTIFIED BY 'forum123';
GRANT ALL PRIVILEGES ON forumhub.* TO 'forumuser'@'localhost';
FLUSH PRIVILEGES;
```

### 🔸 Arquivo application.properties (ajuste com suas credenciais)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forumhub
spring.datasource.username=forumuser                           
spring.datasource.password=forum123
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
api.security.secret=umsegredosecretocommaisde32caracteres!
server.port=8080

- **Configure o application.properties acima de acordo com as configurações que foi feita no seu banco de dados**
```

---

## 📄 Arquivo data.sql

Esse arquivo insere dados automaticamente no banco assim que a aplicação é executada. Útil para testes. **Não é obrigatório.**

```sql
-- Cursos
INSERT INTO curso (nome) VALUES ('Spring');
INSERT INTO curso (nome) VALUES ('Spring Boot');
INSERT INTO curso (nome) VALUES ('Java');

-- Usuários (senha: 123456 criptografada)
INSERT INTO usuario (login, senha) VALUES ('admin', '$2a$10$zkX4eOi2UuEoMKvFbslYWeAjMlQgbvGpU5uXH2lDWRUPn2RPTHcQC');

-- Tópico opcional (exemplo)
INSERT INTO topico (titulo, mensagem, data_criacao, curso_id, autor_id)
VALUES ('Erro ao conectar no banco', 'Não consigo acessar o banco de dados MySQL usando JDBC.', '2025-07-16 10:51:08', 1, 1);
```

---

## 🔐 Autenticação JWT

```http
POST /login
```

Body JSON:

```json
{
  "login": "admin",
  "senha": "123456"
}
```

Header:

```http
Authorization: Bearer SEU_TOKEN **Substitua o "SEU_TOKEN" pelo seu token real**
```

---

## 📡 Endpoints da API

| Método | Endpoint       | Ação               | Protegido |
|--------|----------------|--------------------|-----------|
| POST   | /login         | Gera token JWT     | ❌ Não    |
| GET    | /topicos       | Lista tópicos      | ✅ Sim    |
| POST   | /topicos       | Cria tópico        | ✅ Sim    |
| GET    | /topicos/{id}  | Detalha tópico     | ✅ Sim    |
| PUT    | /topicos/{id}  | Atualiza tópico    | ✅ Sim    |
| DELETE | /topicos/{id}  | Deleta tópico      | ✅ Sim    |

---

## 📍 **URLs por função**

- **Autenticação: `POST http://localhost:8080/login`**
- **Criar tópico: `POST http://localhost:8080/topicos`**
- **Listar tópicos: `GET http://localhost:8080/topicos`**
- **Buscar tópico: `GET http://localhost:8080/topicos/{id}`**
- **Atualizar: `PUT http://localhost:8080/topicos/{id}`**
- **Excluir: `DELETE http://localhost:8080/topicos/{id}`**


## 🧠 Observações

- Para o banco ser criado automaticamente, o Hibernate precisa estar configurado com `ddl-auto=update`
- Caso use Flyway, os scripts SQL de criação de tabelas devem estar em `resources/db/migration`
- `data.sql` insere dados apenas se as tabelas já existirem

---


## 💡 Licença

Este projeto foi desenvolvido como parte do **Desafio Back-End da Alura** e está disponível apenas para fins educacionais.
