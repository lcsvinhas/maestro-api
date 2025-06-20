# Maestro API
API para gerenciamento de bandas e músicos com autenticação e autorização via Spring Security e JWT. Suporta CRUD completo, validação, e controle de acesso baseado em roles (USER e ADMIN). Utiliza JPA com banco H2 para persistência.

---

## Funcionalidades

- CRUD completo para **Bandas** e **Músicos**
- Registro e login de usuários com autenticação JWT
- Controle de acesso baseado em roles (USER, ADMIN)
- Somente usuários autenticados podem acessar recursos protegidos
- Apenas usuários ADMIN podem deletar recursos
- Validação dos dados com Bean Validation
- Persistência usando JPA/Hibernate e banco em memória H2
- Estrutura modularizada com boas práticas de código

---

## Tecnologias

- Java 17+
- Spring Boot 3+
- Spring Security com JWT
- Hibernate / JPA
- H2 Database
- Lombok
- Bean Validation (Jakarta Validation)
- Maven

---

## Requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE (IntelliJ, Eclipse, VSCode) opcional

---

## Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/lcsvinhas/maestro-api.git
2. Basta rodar o projeto na sua IDE favorita. Após a aplicação iniciar, você pode utilizar o Postman, Insomnia ou simplesmente acessar via `localhost` para consumir os endpoints REST.

## Endpoints principais

### Autenticação

- `POST /usuario` — Registrar novo usuário  
- `POST /login` — Login e recebimento do token JWT

### Bandas

- `GET /bandas` — Listar todas as bandas  
- `GET /bandas/{id}` — Buscar banda por ID  
- `POST /bandas` — Criar nova banda  
- `PUT /bandas/{id}` — Atualizar banda  
- `DELETE /bandas/{id}` — Deletar banda (ADMIN apenas)

### Músicos

- `GET /musicos` — Listar músicos  
- `GET /musicos/{id}` — Buscar músico por ID  
- `POST /musicos` — Criar músico  
- `PUT /musicos/{id}` — Atualizar músico  
- `DELETE /musicos/{id}` — Deletar músico (ADMIN apenas)

---

## Autorização e segurança

- Todos os endpoints exceto `GET /bandas/**` e `GET /musicos/**` são protegidos  
- Token JWT deve ser enviado no header `Authorization: Bearer <token>`  
- Operações de DELETE são restritas a usuários com role ADMIN

---

## Validação

- Campos obrigatórios são validados com mensagens claras via Bean Validation  
- Datas e formatos devem respeitar padrões (exemplo: `dataNascimento` em ISO 8601 `yyyy-MM-dd`)

---

## Contato

Desenvolvido por Lucas Vinhas — l.vinhas.lv@gmail.com