# Explorando Padrões de Projetos na Prática com Java

Repositório com as implementações dos padrões de projeto explorados no Lab "Explorando Padrões de Projetos na Prática com Java", evoluído com novos padrões e melhorias.

## Padrões no projeto Spring (API de Clientes)

| Padrão | Onde |
| --- | --- |
| Singleton | Beans do Spring injetados com `@Autowired` (`ClienteServiceImpl`) |
| Strategy/Repository | `ClienteService` / `ClienteServiceImpl`, `ClienteRepository`, `EnderecoRepository` |
| Facade | `ClienteRestController` + `ClienteServiceImpl` escondem a integração com H2 e ViaCEP |
| **Chain of Responsibility** (novo) | Pacote `validacao`: `NomeObrigatorioValidador` → `CepValidador` validam o cliente antes de salvar |
| **Observer** (novo) | Pacote `observer`: `ClienteCadastradoEvent` é publicado no cadastro e `BoasVindasListener` reage a ele |

### Melhorias

- Validação do cliente (nome obrigatório, CEP com 8 dígitos, aceitando `01001-000` ou `01001000`).
- CEP inexistente no ViaCEP retorna erro `400` em vez de falhar na gravação.
- `RestExceptionHandler` devolve `400` para validação e `404` para cliente não encontrado.
- Correção: o `PUT /clientes/{id}` criava um novo registro em vez de atualizar o existente.

## Como executar

```bash
./mvnw spring-boot:run   # API em http://localhost:8080/swagger-ui.html
./mvnw test              # testes unitários
```

Exemplo de cadastro:

```json
POST /clientes
{ "nome": "Maria Silva", "endereco": { "cep": "01001-000" } }
```
