# BetterBoxd — Primeira API com Spring Boot (Workshop SEMITI)

BetterBoxd é um projeto-exemplo em Java com Spring Boot usado no **workshop "Primeira API com Spring Boot"**, parte do evento **SEMITI** do _IFPB — Campus Monteiro_. O objetivo do projeto é servir como base prática para aprender a construir uma API REST completa, cobrindo modelagem, persistência, validação, testes e documentação.

---

## Funcionalidades

O projeto implementa as funcionalidades que serão desenvolvidas durante o workshop:

- Gerenciar usuários
- Gerenciar filmes
- Gerenciar categorias
- Gerenciar avaliações

---

## Tecnologias

- Java 17+
- Spring Boot (Spring Web, Spring Data JPA)
- H2 (in-memory)
- Maven (com `./mvnw` disponível)
- Bibliotecas úteis: `spring-boot-starter-validation`, `springdoc-openapi`, `lombok`

---

## Requisitos

- JDK 17 ou superior
- Git
- Rede/porta livre (padrão: `localhost:8080`)

---

## Como executar (passo a passo)

### Passos iniciais

1.  Clone o repositório:

```bash
git clone https://github.com/seu-usuario/workshop-betterboxd.git
```

2.  Acesse a pasta principal:

```bash
cd workshop-betterboxd/betterboxd
```

> Verifique e altere (se necessário) as configurações em `application.properties`

### Execuções da aplicação:

1.  Executar com `./mvnw`:

```bash
./mvnw spring-boot:run
```

2. Para empacotar e executar:

```bash
./mvnw package
```

```bash
java -jar target/workshop-betterboxd-0.0.1-SNAPSHOT.jar
```

3. Para executar testes:

```bash
./mvnw test
```

---

## Endpoints

### Usuários

- Criar usuário — `POST /usuarios`
- Buscar todas os usuários — `GET /usuarios`
- Buscar avaliações de um usuário — `GET /usuarios/{id}/avaliacoes`

### Avaliações

- Avaliar filme — `POST /avaliacoes`

### Categorias

- Criar categoria — `POST /categorias`
- Buscar todas as categorias — `GET /categorias`
- Buscar filmes por categoria — `GET /categorias/{id}/filmes`
- Atualizar categoria — `PUT /categorias/{id}`

### Filmes

- Criar filme — `POST /filmes`
- Buscar todos os filmes — `GET /filmes`
- Buscar filmes filtrado por nome — `GET /filmes?nome='algumfilme'`
- Excluir filme — `DELETE /filmes/{id}`

---

## Licença

Projeto licenciado sob a **MIT License**.

---

## Colaboradores

- [Atos Alves](https://github.com/atosalves)
- [Robson Batista](https://github.com/robsoncaliban)
