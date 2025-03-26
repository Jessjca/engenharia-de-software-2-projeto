# Arquitetura do Sistema

## 1. Visão Geral

O Sistema de Agenda é uma aplicação desktop desenvolvida em Java, utilizando Java Swing para a interface gráfica e SQLite para persistência de dados. A arquitetura segue o padrão MVC (Model-View-Controller) simplificado, com uma estrutura modular e organizada.

## 2. Camadas da Aplicação

### 2.1 Interface do Usuário (View)
- Implementada usando Java Swing
- Componentes principais:
  - `Main.java`: Classe principal que gerencia a interface
  - `TextShadowLabel.java`: Componente customizado para labels com sombra
  - Painéis para diferentes telas (login, cadastro, agenda)

### 2.2 Lógica de Negócio (Model)
- Classes de domínio:
  - `Usuario.java`: Representa um usuário do sistema
  - `Agendamento.java`: Representa um agendamento
- Regras de negócio implementadas nas classes de domínio

### 2.3 Acesso a Dados (Controller/DAO)
- `DatabaseManager.java`: Gerencia a conexão e operações com o banco de dados
- Implementa operações CRUD para usuários e agendamentos

## 3. Estrutura de Pacotes

```
src/
├── main/
│   ├── java/              # Classes Java
│   │   ├── Main.java           # Interface principal
│   │   ├── TextShadowLabel.java # Componente customizado
│   │   ├── DatabaseManager.java # Gerenciador do banco
│   │   ├── Usuario.java        # Classe de usuário
│   │   └── Agendamento.java    # Classe de agendamento
│   └── resources/         # Recursos do sistema
└── test/
    └── java/             # Classes de teste
        ├── UsuarioTest.java     # Testes de usuário
        ├── AgendamentoTest.java # Testes de agendamento
        └── DatabaseManagerTest.java # Testes do banco
```

## 4. Fluxo de Dados

1. **Interface do Usuário**
   - Captura interações do usuário
   - Validação básica de entrada
   - Atualização da interface

2. **Lógica de Negócio**
   - Validação de regras de negócio
   - Transformação de dados
   - Preparação para persistência

3. **Acesso a Dados**
   - Conexão com banco de dados
   - Execução de operações SQL
   - Persistência de dados

## 5. Banco de Dados

### 5.1 Estrutura
- Banco de dados SQLite
- Tabelas:
  - `usuarios`: Armazena dados dos usuários
  - `agendamentos`: Armazena os agendamentos

### 5.2 Schema

```sql
CREATE TABLE usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    senha TEXT NOT NULL
);

CREATE TABLE agendamentos (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    usuario_id INTEGER NOT NULL,
    data DATE NOT NULL,
    hora TEXT NOT NULL,
    descricao TEXT NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);
```

## 6. Componentes Principais

### 6.1 Main
- Ponto de entrada da aplicação
- Gerencia a interface principal
- Controla a navegação entre telas
- Coordena a comunicação entre camadas

### 6.2 DatabaseManager
- Gerencia conexão com banco de dados
- Implementa operações CRUD
- Trata erros de banco de dados
- Mantém conexão única
- Limpa o banco entre testes

### 6.3 Classes de Domínio
- Encapsulam dados e regras de negócio
- Implementam validações
- Mantêm consistência dos dados
- Possuem testes unitários

### 6.4 Testes
- Implementados com JUnit 4.13.2
- Testes unitários para cada classe
- Validação de regras de negócio
- Limpeza automática do banco entre testes

## 7. Padrões de Design Utilizados

### 7.1 Singleton
- Aplicado no `DatabaseManager` para garantir uma única instância de conexão

### 7.2 MVC Simplificado
- Separação clara entre interface, lógica e dados
- Facilita manutenção e evolução

### 7.3 DAO (Data Access Object)
- Abstração do acesso a dados
- Encapsulamento de operações SQL

## 8. Tratamento de Erros

### 8.1 Interface
- Validação de entrada de dados
- Mensagens de erro amigáveis
- Feedback visual para o usuário

### 8.2 Banco de Dados
- Tratamento de exceções SQL
- Validação de integridade
- Logging de erros

## 9. Segurança

### 9.1 Autenticação
- Validação de credenciais
- Proteção contra SQL injection
- Senhas armazenadas com hash

### 9.2 Autorização
- Controle de acesso por usuário
- Validação de permissões
- Proteção de dados sensíveis

## 10. Manutenibilidade

### 10.1 Código
- Organização modular
- Nomenclatura clara
- Comentários explicativos
- Baixo acoplamento

### 10.2 Banco de Dados
- Schema bem definido
- Índices apropriados
- Constraints de integridade
- Backup e recuperação

## 11. Escalabilidade

### 11.1 Atual
- Suporte a múltiplos usuários
- Persistência eficiente
- Interface responsiva

### 11.2 Futura
- Possibilidade de migração para outros bancos
- Adição de novas funcionalidades
- Melhorias de performance 