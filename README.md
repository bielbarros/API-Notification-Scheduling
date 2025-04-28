# Notification Scheduling API

Serviço backend para gerenciamento e envio programado de notificações. Implementado com **Java 21** e **Spring Boot**, oferece APIs RESTful para agendar, consultar e cancelar notificacões.

---

## Funcionalidades

- Agendamento de notificações com data e hora especificadas.
- Recuperação de detalhes de uma notificação via ID.
- Cancelamento de notificações pendentes.
- Processamento automático de envio baseado em data/hora.

---

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- Hibernate (JPA Provider)
- Banco de dados relacional (ex: PostgreSQL, MySQL)

---

## Estrutura de Pacotes

```
gerenciador.magalums
├── config
│   └── DataLoader.java
├── controller
│   └── NotificationController.java
│   └── dto
│       └── ScheduleNotificationDto.java
├── entity
│   └── Notification.java
│   └── Channel.java
│   └── Status.java
├── repository
│   └── NotificationRepository.java
│   └── ChannelRepository.java
│   └── StatusRepository.java
├── service
│   └── NotificationService.java
├── scheduler
   └── MagaluTaskScheduler.java
```

---

## Documentação dos Endpoints

### 1. Agendar uma Notificação

**POST** `/notifications`

**Request Body:**
```json
{
  "dateTime": "2025-04-27T15:30:00",
  "destination": "example@example.com",
  "message": "Mensagem de teste",
  "channel": "EMAIL"
}
```

**Respostas:**
- `202 Accepted` - Notificação agendada.

---

### 2. Buscar uma Notificação por ID

**GET** `/notifications/{notificationId}`

**Parâmetro de Path:**
- `notificationId` (Long) - Identificador da notificação.

**Respostas:**
- `200 OK` - Notificação encontrada.
- `404 Not Found` - Notificação não encontrada.

---

### 3. Cancelar uma Notificação

**DELETE** `/notifications/{notificationId}`

**Parâmetro de Path:**
- `notificationId` (Long) - Identificador da notificação.

**Respostas:**
- `204 No Content` - Cancelamento realizado.

---

## Fluxo de Processamento de Notificações

1. O método `checkAndSend(LocalDateTime dateTime)` recupera todas as notificações:
    - Com status **PENDING** ou **ERROR**;
    - Com `dateTime` anterior ou igual ao fornecido.

2. Para cada notificação encontrada:
    - **[TODO]**: Executar o envio real da mensagem (Exemplo: disparar e-mail, SMS, etc.).
    - Atualizar o status para **SUCCESS** após envio.

**Notas:**
- O envio real ainda é um TODO a ser implementado.
- A aplicação utiliza um `Consumer<Notification>` para encapsular a lógica de envio.

---

## Modelagem de Domínio

### Entidade Notification

| Campo        | Tipo                | Descrição                                |
|--------------|---------------------|-------------------------------------------|
| id           | Long                | Identificador único                     |
| dateTime     | LocalDateTime       | Data e hora para envio                    |
| destination  | String              | Destinatário (e-mail, telefone, etc.)     |
| message      | String              | Conteúdo da notificação                  |
| channel      | Channel             | Canal de envio                            |
| status       | Status              | Status da notificação (PENDING, SUCCESS, etc.) |

---

## Status da Notificação

- `PENDING` - Notificação agendada, aguardando envio.
- `SUCCESS` - Envio realizado com sucesso.
- `ERROR` - Erro durante envio (retratamento futuro).
- `CANCELED` - Notificação cancelada manualmente.

---

## Como Executar Localmente

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/seu-repo.git

# Acesse o projeto
cd seu-repo

# Execute a aplicação
./mvnw spring-boot:run
```

O servidor será iniciado em: `http://localhost:8080`

---

## Observações

- Certifique-se de configurar corretamente a fonte de dados no `application.properties` ou `application.yml`.
- O módulo de envio de notificações é apenas simulado e requer implementação real.
- O projeto está preparado para extensão utilizando boas práticas de engenharia de software.

---

> **Gabriel Barros – Full Stack Developer (Java & Angular)**  
**Email:** [gabrielbarrosg11@gmail.com]  
**LinkedIn:** [linkedin.com/in/gabriel-sbarros](#)