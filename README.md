# Sistema de Gerenciamento de Usuários

Projeto desenvolvido para a disciplina **Imersão Profissional: Desenvolvimento de Aplicação Web**, utilizando **Spring Boot** para construção de uma API REST segura com autenticação JWT, persistência de dados em MySQL e uma interface Front-end desenvolvida com HTML, CSS e JavaScript.

---

## 📋 Descrição

Este projeto consiste em um sistema de gerenciamento de usuários desenvolvido com Java e Spring Boot no Back-end, integrado a uma interface Front-end para interação com a API.

A aplicação permite:

* Cadastro de usuários
* Autenticação via JWT
* Gerenciamento de usuários
* Comunicação entre Front-end e API REST
* Persistência de dados em banco MySQL

O objetivo é aplicar conceitos de desenvolvimento Web Full Stack, segurança de aplicações, integração entre camadas e versionamento de código.

---

## 🚀 Tecnologias Utilizadas

### Back-end

* Java 21
* Spring Boot
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)
* Maven

### Front-end

* HTML5
* CSS3
* JavaScript

### Banco de Dados

* MySQL

### Ferramentas

* Eclipse IDE
* Visual Studio Code
* Git
* GitHub
* Postman

---

## 📂 Estrutura do Projeto

```text
projetoescola_projetoescola
│
├── frontend
│   ├── index.html
│   ├── css
│   ├── js
│   └── assets
│
├── src
│   ├── main
│   │   ├── java
│   │   │   └── br.com.projetoescola
│   │   │       ├── controllers
│   │   │       ├── services
│   │   │       ├── repositories
│   │   │       ├── models
│   │   │       ├── dto
│   │   │       └── security
│   │   │
│   │   └── resources
│   │       └── application.properties
│   │
│   └── test
│
└── pom.xml
```

---

## 🔐 Funcionalidades

### Back-end

* Cadastro de usuários
* Login de usuários
* Geração de Token JWT
* Autenticação de requisições
* Controle de acesso
* Persistência em MySQL
* API RESTful

### Front-end

* Interface para cadastro de usuários
* Interface para login
* Consumo da API REST
* Envio de requisições HTTP
* Integração com autenticação JWT

---

## 🛠 Configuração do Banco de Dados

Crie o banco:

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

### 2. Entrar na pasta do projeto

```bash
cd projetoescola_projetoescola
```

### 3. Instalar dependências

```bash
mvn clean install
```

### 4. Executar a API

```bash
mvn spring-boot:run
```

Ou executar pela classe:

```java
ProjetoescolaApplication.java
```

### 5. Executar o Front-end

Abra o arquivo:

```text
frontend/index.html
```

no navegador ou utilizando a extensão Live Server do VS Code.

---

## 📡 Endpoints da API

### Login

```http
POST /auth/login
```

```json
{
  "email": "usuario@email.com",
  "password": "123456"
}
```

### Cadastro

```http
POST /auth/register
```

```json
{
  "name": "Luis Paulo",
  "email": "usuario@email.com",
  "password": "123456"
}
```

---

## 🔒 Segurança

O sistema utiliza:

* Spring Security
* JWT Authentication
* Filtros de autenticação
* Proteção de endpoints
* Controle de acesso por token

Fluxo:

1. Usuário realiza login.
2. Sistema gera Token JWT.
3. Cliente envia:

```http
Authorization: Bearer SEU_TOKEN
```

4. API valida o token.
5. Requisição é autorizada.

---

## 🧪 Testes

A API pode ser testada utilizando:

* Postman
* Insomnia
* Swagger (quando configurado)

---

## 📚 Conceitos Aplicados

* Orientação a Objetos
* APIs REST
* Spring Boot
* Spring Security
* JWT
* JPA/Hibernate
* Persistência de Dados
* Front-end Web
* Integração Front-end e Back-end
* Maven
* Git e GitHub

---

## 🎓 Projeto Acadêmico

Disciplina:

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

Projeto desenvolvido para fins educacionais e de aprendizagem.
Todos os direitos reservados ao autor.
