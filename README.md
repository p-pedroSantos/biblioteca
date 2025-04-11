# 📚 Sistema de Gerenciamento de Biblioteca (Spring MVC + MySQL)

Este projeto é uma aplicação web simples para gerenciamento de uma biblioteca, construída com **Spring Boot** e arquitetura **MVC**. Permite o cadastro, listagem, edição e exclusão de livros, com persistência de dados em um banco relacional **MySQL** e interface HTML com **Thymeleaf**.

---

## ✨ Funcionalidades

- ✅ Cadastro de livros com título, autor, ano, etc.  
- 📋 Listagem de todos os livros disponíveis  
- 📝 Edição das informações dos livros  
- ❌ Exclusão de livros do acervo  
- 🔍 Interface web intuitiva com navegação por páginas

---

## 🛠️ Tecnologias Utilizadas

- Java 11  
- Spring Boot 2.7.5  
- Spring MVC  
- Spring Data JPA  
- Thymeleaf  
- MySQL  
- Maven  

---

## ⚙️ Configuração do Banco de Dados

Configure as credenciais no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
