# AlgaFood API - Gestão de Cidades, Cozinhas, Estados e Restaurantes

API REST desenvolvida em Java com Spring Boot para gerenciar entidades do sistema AlgaFood.

---

## Funcionalidades

### Cidades (`/cidades`)
- Listar todas as cidades  
- Buscar cidade por ID  
- Criar nova cidade  
- Atualizar cidade existente  
- Remover cidade  
- Validação e tratamento de exceção para estado não encontrado

### Cozinhas (`/cozinhas`)
- Listar todas as cozinhas  
- Buscar cozinha por ID  
- Criar nova cozinha  
- Atualizar cozinha existente  
- Remover cozinha

### Estados (`/estados`)
- Listar todos os estados  
- Buscar estado por ID  
- Criar novo estado  
- Atualizar estado existente  
- Remover estado

### Restaurantes (`/restaurantes`)
- Listar todos os restaurantes  
- Buscar restaurante por ID  
- Criar novo restaurante (validação de existência de cozinha)  
- Atualizar restaurante existente

---

## Endpoints principais

| Método | Caminho               | Descrição                          |
|--------|-----------------------|----------------------------------|
| GET    | `/cidades`            | Listar todas as cidades           |
| GET    | `/cidades/{id}`       | Buscar cidade por ID              |
| POST   | `/cidades`            | Criar nova cidade                 |
| PUT    | `/cidades/{id}`       | Atualizar cidade                  |
| DELETE | `/cidades/{id}`       | Remover cidade                   |
| GET    | `/cozinhas`           | Listar todas as cozinhas          |
| GET    | `/cozinhas/{id}`      | Buscar cozinha por ID             |
| POST   | `/cozinhas`           | Criar nova cozinha                |
| PUT    | `/cozinhas/{id}`      | Atualizar cozinha                 |
| DELETE | `/cozinhas/{id}`      | Remover cozinha                  |
| GET    | `/estados`            | Listar todos os estados           |
| GET    | `/estados/{id}`       | Buscar estado por ID              |
| POST   | `/estados`            | Criar novo estado                 |
| PUT    | `/estados/{id}`       | Atualizar estado                  |
| DELETE | `/estados/{id}`       | Remover estado                   |
| GET    | `/restaurantes`       | Listar todos os restaurantes      |
| GET    | `/restaurantes/{id}`  | Buscar restaurante por ID         |
| POST   | `/restaurantes`       | Criar novo restaurante (valida cozinha) |
| PUT    | `/restaurantes/{id}`  | Atualizar restaurante (valida cozinha) |

---

## Tecnologias e conceitos usados

- Java 17  
- Spring Boot (Web, Data JPA, Validation)  
- Controllers REST com anotações Spring MVC  
- Conversão entre DTOs (input/model) e entidades com assemblers e disassemblers  
- Tratamento de exceções específicas para regras de negócio (ex: estado ou cozinha não encontrados)  
- HTTP status codes apropriados (201 Created, 204 No Content, etc.)
