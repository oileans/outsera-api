# API Test Automation – JSONPlaceholder

Este projeto realiza testes automatizados de API REST utilizando:
- ✅ Java 17
- ✅ Rest Assured
- ✅ JUnit 5
- ✅ Allure Reports

Os testes são executados contra a API pública https://jsonplaceholder.typicode.com, simulando operações reais (GET, POST, PUT, DELETE) para fins de aprendizado e validação de automações de backend.

---

## Tecnologias e Bibliotecas

| Ferramenta    | Finalidade                          |
|---------------|--------------------------------------|
| Java 17+      | Linguagem base                       |
| Maven         | Gerenciamento de dependências        |
| JUnit 5       | Framework de testes                  |
| Rest Assured  | Testes de API REST                   |
| Hamcrest      | Validações e matchers                |
| Allure Report | Relatórios gráficos de execução      |


---

## Como executar os testes

### 1. Clonar o projeto

* git clone git@github.com:oileans/outsera-api.git

### 2. Executar projeto

* mvn test -Denv=prod

### 3. Gerar alure report

* Instalar o [Allure](https://github.com/allure-framework/allure2/releases) CLI
* run 'Allure serve allure-results' (Necessario passar o caminho absudo da pasta allure-results)

