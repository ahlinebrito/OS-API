# API de Controle de Ordens de Serviço (OS)

API RESTful de exemplo feita com **Java 17 + Spring Boot 3** e banco **H2** em memória.
O domínio escolhido — Ordens de Serviço — representa um cenário comum em empresas de logística e prestação de serviços: cada OS tem um número identificador único, um cliente vinculado, uma data de abertura e um status que evolui ao longo do processo (PENDENTE → EM_ANDAMENTO → CONCLUIDA, podendo também ser CANCELADA).

## Como rodar

```bash
mvn spring-boot:run
```

A aplicação sobe em `http://localhost:8080`.
Console do H2 disponível em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:osdb`, usuário `sa`, sem senha).

## Endpoints

| Método | Rota                              | Descrição                          |
|--------|------------------------------------|-------------------------------------|
| GET    | `/api/ordens-servico`             | Lista todas as OS                   |
| GET    | `/api/ordens-servico?status=PENDENTE` | Filtra por status                |
| GET    | `/api/ordens-servico/{id}`        | Busca uma OS por id                 |
| POST   | `/api/ordens-servico`             | Cria uma nova OS                    |
| PUT    | `/api/ordens-servico/{id}`        | Atualiza uma OS existente           |
| DELETE | `/api/ordens-servico/{id}`        | Remove uma OS                       |

Status possíveis: `PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`, `CANCELADA`.

## Exemplo de criação (POST)

```json
{
  "numeroOs": "OS-2026-0001",
  "cliente": "Transportadora Azul Ltda",
  "descricao": "Emissao de CTE pendente",
  "dataAbertura": "2026-09-01",
  "status": "PENDENTE"
}
```

## Estrutura do projeto

```
src/main/java/com/dms/osapi/
├── OsApiApplication.java        # classe principal
├── model/
│   ├── OrdemServico.java        # entidade JPA
│   └── StatusOS.java            # enum de status
├── repository/
│   └── OrdemServicoRepository.java
├── service/
│   └── OrdemServicoService.java # regras de negocio
├── controller/
│   └── OrdemServicoController.java # endpoints REST
└── exception/
    ├── OrdemServicoNaoEncontradaException.java
    └── GlobalExceptionHandler.java  # tratamento de erros
```
