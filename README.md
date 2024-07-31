
<h1 align="center">
    Gerenciador de Tarefas<br><br>
	<img src="https://i.imgur.com/kVQuUcY.png"  alt="Logo"  width="200"><br>
</h1>

# Projeto Java Spring Boot

Este projeto é uma aplicação Java Spring Boot que implementa uma plataforma para gerenciamento de usuários, salas, tarefas e envio de emails. Ele utiliza arquitetura MVC, JPA Repository para acesso a dados e segue os princípios SOLID.

## 📌 Descrição

A aplicação fornece funcionalidades para gerenciar:
- Usuários
- Pessoas
- Salas
- Tarefas
- Agendamento
- Envio de emails
<br>

<div>
    <p align="center">
    API-REST de gerenciamento de tarefas, analise de código com SonarQube e deploy realizado na AWS EC2!
    </p>
</div>

<br>

## 🚀Features

- **Gerenciamento de Usuários**: Criação, atualização, leitura e exclusão de usuários.
- **Gerenciamento de Pessoas**: Criação, atualização, leitura e exclusão de pessoas.
- **Gerenciamento de Salas**: Criação, atualização, leitura e exclusão de salas.
- **Gerenciamento de Tarefas**: Criação, atualização, leitura e exclusão de tarefas.
- **Agendamento de Tarefas**: Agendamento automático de tarefas.
- **Envio de Emails**: Envio de emails para usuários e notificações.
<br>

## 🌐Technologies

- Java 8
- JPA
- Maven
- Spring Boot
- Swagger
- PostgreSQL
- Postman
- SonarQube
- AWS-EC2



## 📕Installation
Antes de começar, certifique-se de que você atendeu aos seguintes requisitos:
- Java 11 ou superior
- Maven 3.6 ou superior
- MySQL ou outro banco de dados configurado
- 
**Recomendações**
- É recomendável que você tenha instalado o Google Chrome ou Edge
- Eu recomendo usar o Eclipse como IDE de desenvolvimento

**A instalação e inicialização são 4 etapas!**
1. Clone este repositório
2. Entre na pasta descompactada
3. Build com Maven
4. Rode o projeto com o Docker Compose

Para instalar o projeto, siga estas etapas:

1. Clone o repositório
    ```bash
    https://github.com/jpgfigueired0/desafio-de-projeto-tarefas-casa.git
    ```

2. Navegue até o diretório do projeto
    ```bash
    cd desafio-de-projeto-tarefas-casa
    ```

3. Instale as dependências
    ```bash
    mvn install
    ```

## Configuração

Configure o arquivo `application.properties` ou `application.yml` no diretório `src/main/resources` com as suas configurações de banco de dados e outras configurações necessárias.

Exemplo de configuração em `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
jwt.secret=seu_jwt_secreto
email.username=seu_email
email.password=sua_senha
```

## 🎮Getting Started
- Abra o navegador e entre no seguinte link: http://localhost:8080
    - O link acima irá abrir o Swagger do projeto em questão!
    - Teste API via Postman or Insomnia
<br>

## 📁PostgreSQL
**Para utilizar o banco de dados siga os seguintes passos**

### 1. Rode o comando abaixo no Terminal e copie o CONTAINER ID do postgres
```
docker ps
```
---
### 2. Entre no banco de dados com o comando abaixo (Obs: substitua o CONTAINER ID)
```
docker exec -it ContainerID psql -U postgres tasks
```
---
<br>

**Alguns comandos do PostgreSQL**
### Listar todas tabelas
```
\dt
```
---
### Listar tabela room
```
select * from tb_comodo;
```
