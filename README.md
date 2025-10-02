# service-task

Serviço de tarefas do projeto [microservices-demo](https://github.com/Lucas-319/microservices-demo). Cria tarefas e verifica, de forma agendada, aquelas com vencimento por data. Quando necessário, aciona o [service-notification](https://github.com/Lucas-319/service-notification) para envio de e-mails (OpenFeign + Eureka).

## Tecnologias
- Java 21
- Maven
- Spring Boot
- Spring Cloud: OpenFeign, Netflix Eureka, Config Client
- Spring Data JPA + H2 (in-memory)
- Docker

## Porta e Endpoints
- Porta: `8081`
- API:
  - `POST /task` — cria uma tarefa
  - `GET /server-port` — endpoint utilitário
 - Console H2:
    - `GET /h2-console` (apenas dev)
        - JDBC: `jdbc:h2:mem:task`
        - Usuário: `admin`
        - Senha: (vazio)

## Como se integra no projeto
- Descoberta e configuração:
  - Carrega propriedades do Config Server hospedado em [service-main](https://github.com/Lucas-319/service-main) (prefixo `/config`).
  - Registra-se no Eureka (também no `service-main`) para localizar serviços por nome lógico.
- Fluxo com o [service-notification](https://github.com/Lucas-319/service-notification):
  1. Ao identificar que uma tarefa deve ser notificada, realiza uma chamada HTTP via OpenFeign (FeignClient) para `POST /notification` com `{"message":"...","email":"..."}`.
  2. A resolução do endereço ocorre via Eureka, usando o nome lógico do serviço de notificação.
  3. O service-notification envia o e-mail via JavaMail para o Mailhog (SMTP `mailhog:1025`).

## Observação (agendamento)
- Nesta demo, o scheduler roda a cada ~60s para facilitar a visualização.
- Em um cenário real, a verificação seria diária, pois a regra é baseada em data e não em horário.
