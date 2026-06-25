# Sistema de Gerenciamento de Usuários

Projeto desenvolvido para a disciplina **Imersão Profissional: Desenvolvimento de Aplicação Web**, utilizando Spring Boot para construção de uma API REST segura com autenticação JWT e persistência de dados em MySQL.

---

## 📋 Descrição

Este projeto consiste em um sistema de gerenciamento de usuários desenvolvido com Java e Spring Boot. A aplicação permite o cadastro, autenticação e gerenciamento de usuários através de uma API REST protegida por JWT (JSON Web Token).

O objetivo do projeto é aplicar conceitos de desenvolvimento Back-end, segurança de aplicações, persistência de dados e integração com banco de dados relacional.

---

## 🚀 Tecnologias Utilizadas

### Back-end

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* Maven

### Banco de Dados

* MySQL

### Ferramentas

* Eclipse IDE
* Git
* GitHub
* Postman (testes da API)

---

## 📂 Estrutura do Projeto

```text
src
├── main
│   ├── java
│   │   └── br.com.projetoescola
│   │       ├── controllers
│   │       ├── services
│   │       ├── repositories
│   │       ├── models
│   │       ├── dto
│   │       └── security
│   │
│   └── resources
│       └── application.properties
│
└── test
```

---

## 🔐 Funcionalidades

* Cadastro de usuários
* Login de usuários
* Geração de Token JWT
* Autenticação de requisições
* Controle de acesso por segurança
* Persistência de dados em MySQL
* API RESTful
* Tratamento de requisições HTTP

---

## 🛠 Configuração do Banco de Dados

Crie um banco de dados no MySQL:

```sql
CREATE DATABASE projetoescola;
```

Configure o arquivo:

```properties
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projetoescola
spring.datasource.username=root
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ⚙️ Como Executar o Projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/luispaulonunes/projetoescola-springboot.git
```

### 2. Acessar a pasta do projeto

```bash
cd projetoescola_projetoescola
```

### 3. Atualizar dependências Maven

```bash
mvn clean install
```

### 4. Executar a aplicação

```bash
mvn spring-boot:run
```

Ou executar diretamente pela IDE Eclipse através da classe principal:

```java
ProjetoescolaApplication.java
```

---

## 📡 Exemplos de Endpoints

### Autenticação

#### Login

```http
POST /auth/login
```

Exemplo de requisição:

```json
{
  "email": "usuario@email.com",
  "password": "123456"
}
```

---

### Cadastro de Usuário

```http
POST /auth/register
```

Exemplo:

```json
{
  "name": "Luis Paulo",
  "email": "usuario@email.com",
  "password": "123456"
}
```

---

## 🔒 Segurança

A aplicação utiliza:

* Spring Security
* JWT Authentication
* Filtros de autenticação
* Proteção de endpoints
* Controle de acesso baseado em token

Fluxo de autenticação:

1. Usuário realiza login.
2. Sistema gera um Token JWT.
3. Cliente envia o token no Header:

```http
Authorization: Bearer SEU_TOKEN
```

4. A API valida o token e autoriza a requisição.

---

## 🧪 Testes

Os endpoints podem ser testados utilizando:

* Postman
* Insomnia
* Swagger (quando configurado)

---

## 📚 Conceitos Aplicados

* Orientação a Objetos
* APIs REST
* Injeção de Dependência
* Spring IoC
* Spring Security
* JWT
* JPA/Hibernate
* Persistência de Dados
* Maven
* Versionamento com Git

---

## 🎓 Projeto Acadêmico

Projeto desenvolvido para fins acadêmicos na disciplina:

**Imersão Profissional: Desenvolvimento de Aplicação Web**

Curso:

**Tecnólogo em Sistemas para Internet**

---

## 👨‍💻 Autor

**Luis Paulo Nunes**

Estudante de Tecnologia em Sistemas para Internet.

GitHub:

https://github.com/luispaulonunes

---

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais e de aprendizagem.
Todos os direitos reservados ao autor.
