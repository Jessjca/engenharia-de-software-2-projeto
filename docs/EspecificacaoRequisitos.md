# Especificação de Requisitos

## 1. Introdução
Este documento descreve os requisitos funcionais e não-funcionais do Sistema de Agendamento de Compromissos.

## 2. Requisitos Funcionais

### 2.1 Gestão de Usuários
#### RF1 - Cadastro de Usuário
- O sistema deve permitir o cadastro de novos usuários
- Dados obrigatórios: nome, email e senha
- O email deve ser único no sistema
- A senha deve ter no mínimo 6 caracteres

#### RF2 - Autenticação
- O sistema deve permitir o login de usuários cadastrados
- O login deve ser realizado com email e senha
- O sistema deve validar as credenciais fornecidas
- Em caso de credenciais inválidas, exibir mensagem de erro

### 2.2 Gestão de Agendamentos
#### RF3 - Criação de Agendamento
- O sistema deve permitir a criação de novos agendamentos
- Dados obrigatórios: data, hora e descrição
- A data não pode ser anterior à data atual
- O horário deve estar dentro do horário comercial (8h às 18h)

#### RF4 - Visualização de Agendamentos
- O sistema deve listar todos os agendamentos do usuário logado
- Os agendamentos devem ser ordenados por data e hora
- Deve ser possível filtrar agendamentos por data
- Cada agendamento deve exibir: data, hora e descrição

#### RF5 - Cancelamento de Agendamento
- O sistema deve permitir o cancelamento de agendamentos
- Apenas o usuário que criou o agendamento pode cancelá-lo
- O sistema deve solicitar confirmação antes do cancelamento
- Após o cancelamento, o agendamento deve ser removido da lista

## 3. Requisitos Não-Funcionais

### 3.1 Usabilidade
#### RNF1 - Interface Gráfica
- A interface deve ser intuitiva e fácil de usar
- O sistema deve seguir um padrão visual consistente
- Os botões e campos devem ter tamanhos adequados para interação
- As mensagens de erro devem ser claras e objetivas

#### RNF2 - Responsividade
- A interface deve se adaptar a diferentes resoluções de tela
- O sistema deve funcionar adequadamente em monitores com resolução mínima de 1024x768

### 3.2 Performance
#### RNF3 - Tempo de Resposta
- O sistema deve responder às ações do usuário em no máximo 2 segundos
- A listagem de agendamentos deve ser carregada em no máximo 1 segundo

#### RNF4 - Concorrência
- O sistema deve suportar múltiplos usuários simultaneamente
- As operações de banco de dados devem ser thread-safe

### 3.3 Segurança
#### RNF5 - Proteção de Dados
- As senhas devem ser armazenadas de forma criptografada
- Os dados dos usuários devem ser protegidos contra acesso não autorizado
- O sistema deve implementar timeout de sessão após 30 minutos de inatividade

### 3.4 Confiabilidade
#### RNF6 - Persistência
- Os dados devem ser persistidos em banco de dados SQLite
- O sistema deve manter a integridade dos dados mesmo em caso de falha
- Deve ser possível recuperar os dados em caso de corrupção do banco

#### RNF7 - Validação
- Todos os dados de entrada devem ser validados
- O sistema deve prevenir a inserção de dados inválidos
- As operações críticas devem ser registradas em log

## 4. Restrições Técnicas
- O sistema deve ser desenvolvido em Java
- A interface gráfica deve utilizar Swing
- Os testes devem ser implementados com JUnit
- O banco de dados deve ser SQLite
- O sistema deve seguir o padrão de arquitetura MVC 