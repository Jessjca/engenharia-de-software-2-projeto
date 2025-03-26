# Projeto Arquitetural

## 1. Introdução
Este documento descreve a arquitetura do Sistema de Agendamento de Compromissos, incluindo os diagramas UML e a estrutura do sistema.

## 2. Arquitetura do Sistema

### 2.1 Padrão MVC
O sistema foi desenvolvido seguindo o padrão de arquitetura MVC (Model-View-Controller):

- **Model**: Classes que representam os dados e a lógica de negócio
  - `Usuario`: Representa um usuário do sistema
  - `Agendamento`: Representa um compromisso
  - `DatabaseManager`: Gerencia o acesso ao banco de dados

- **View**: Classes responsáveis pela interface do usuário
  - `MainView`: Interface principal do sistema
  - `BackgroundPanel`: Painel com imagem de fundo

- **Controller**: Classes que controlam o fluxo da aplicação
  - `MainController`: Controlador principal que coordena as operações

### 2.2 Estrutura de Pacotes
```
src/
├── main/
│   └── java/
│       ├── model/      # Classes de modelo
│       ├── controller/ # Controladores
│       └── view/       # Interface gráfica
└── test/
    └── java/          # Testes unitários
```

## 3. Diagramas UML

### 3.1 Diagrama de Classes
```plantuml
@startuml
class Usuario {
  -id: int
  -nome: String
  -email: String
  -senha: String
  +getId(): int
  +setId(int)
  +getNome(): String
  +setNome(String)
  +getEmail(): String
  +setEmail(String)
  +getSenha(): String
  +setSenha(String)
}

class Agendamento {
  -id: int
  -usuarioId: int
  -data: Date
  -hora: String
  -descricao: String
  +getId(): int
  +setId(int)
  +getUsuarioId(): int
  +setUsuarioId(int)
  +getData(): Date
  +setData(Date)
  +getHora(): String
  +setHora(String)
  +getDescricao(): String
  +setDescricao(String)
}

class DatabaseManager {
  -connection: Connection
  +cadastrarUsuario(Usuario)
  +buscarUsuario(String)
  +criarAgendamento(Agendamento)
  +listarAgendamentos(int)
  +excluirAgendamento(int)
}

class MainController {
  -databaseManager: DatabaseManager
  +cadastrarUsuario(String, String, String)
  +login(String, String)
  +criarAgendamento(int, Date, String, String)
  +listarAgendamentos(int)
  +excluirAgendamento(int)
}

class MainView {
  -controller: MainController
  +criarPainelLogin()
  +criarPainelCadastro()
  +criarPainelPrincipal()
}

class BackgroundPanel {
  -image: Image
  +setAlpha(float)
  +paintComponent(Graphics)
}

Usuario "1" -- "*" Agendamento
DatabaseManager "1" -- "*" Usuario
DatabaseManager "1" -- "*" Agendamento
MainController "1" -- "1" DatabaseManager
MainView "1" -- "1" MainController
MainView "1" -- "*" BackgroundPanel
@enduml
```

### 3.2 Diagrama de Componentes
```plantuml
@startuml
package "Interface do Usuário" {
  [MainView]
  [BackgroundPanel]
}

package "Lógica de Negócio" {
  [MainController]
}

package "Persistência" {
  [DatabaseManager]
  database "SQLite" {
    [Usuarios]
    [Agendamentos]
  }
}

[MainView] --> [MainController]
[MainController] --> [DatabaseManager]
[DatabaseManager] --> [Usuarios]
[DatabaseManager] --> [Agendamentos]
@enduml
```

### 3.3 Diagrama de Sequência - Login
```plantuml
@startuml
actor Usuario
participant "MainView" as View
participant "MainController" as Controller
participant "DatabaseManager" as DB

Usuario -> View: Informa email e senha
View -> Controller: login(email, senha)
Controller -> DB: buscarUsuario(email)
DB --> Controller: retorna usuário
Controller -> Controller: valida senha
Controller --> View: retorna resultado
View --> Usuario: exibe mensagem
@enduml
```

## 4. Fluxos de Dados

### 4.1 Cadastro de Usuário
1. Usuário preenche formulário de cadastro
2. View valida os dados
3. Controller processa o cadastro
4. DatabaseManager persiste os dados
5. View exibe mensagem de sucesso/erro

### 4.2 Criação de Agendamento
1. Usuário preenche formulário de agendamento
2. View valida data e hora
3. Controller processa o agendamento
4. DatabaseManager persiste os dados
5. View atualiza lista de agendamentos

### 4.3 Cancelamento de Agendamento
1. Usuário seleciona agendamento
2. View solicita confirmação
3. Controller processa o cancelamento
4. DatabaseManager remove o registro
5. View atualiza lista de agendamentos

## 5. Considerações de Implementação

### 5.1 Tratamento de Erros
- Validação de dados em todas as camadas
- Mensagens de erro claras e objetivas
- Logging de exceções para debug

### 5.2 Segurança
- Criptografia de senhas
- Validação de sessão
- Proteção contra SQL injection

### 5.3 Performance
- Conexão pool com banco de dados
- Cache de dados frequentemente acessados
- Otimização de consultas SQL 