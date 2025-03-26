# Requisitos do Sistema

## 1. Introdução

Este documento descreve os requisitos funcionais e não funcionais do Sistema de Agenda, uma aplicação desktop desenvolvida em Java para gerenciamento de compromissos.

## 2. Requisitos Funcionais

### 2.1 Gerenciamento de Usuários

#### 2.1.1 Cadastro de Usuário
- O sistema deve permitir o cadastro de novos usuários
- Dados necessários:
  - Nome completo
  - Email válido
  - Senha (mínimo 6 caracteres)
- Validações:
  - Email não pode estar em uso
  - Senha deve ter no mínimo 6 caracteres
  - Nome não pode estar vazio

#### 2.1.2 Login
- O sistema deve permitir o acesso com email e senha
- Validações:
  - Email deve estar cadastrado
  - Senha deve corresponder ao email
- Feedback:
  - Mensagem de erro para credenciais inválidas
  - Redirecionamento para agenda após login bem-sucedido

### 2.2 Gerenciamento de Agendamentos

#### 2.2.1 Criação de Agendamento
- O sistema deve permitir criar novos agendamentos
- Dados necessários:
  - Data do compromisso
  - Hora do compromisso
  - Descrição do compromisso
- Validações:
  - Data não pode ser anterior à data atual
  - Hora deve estar no formato HH:mm
  - Descrição não pode estar vazia

#### 2.2.2 Visualização de Agendamentos
- O sistema deve exibir todos os agendamentos do usuário
- Organização:
  - Ordenados por data e hora
  - Agrupados por data
- Informações exibidas:
  - Data
  - Hora
  - Descrição

#### 2.2.3 Cancelamento de Agendamento
- O sistema deve permitir cancelar agendamentos
- Processo:
  - Seleção do agendamento
  - Confirmação do cancelamento
  - Atualização da lista

## 3. Requisitos Não Funcionais

### 3.1 Interface do Usuário

#### 3.1.1 Design
- Interface gráfica moderna e intuitiva
- Cores agradáveis e contrastantes
- Fontes legíveis
- Elementos bem organizados

#### 3.1.2 Usabilidade
- Navegação simples e intuitiva
- Feedback visual para ações
- Mensagens claras e objetivas
- Tempo de resposta < 2 segundos

### 3.2 Performance

#### 3.2.1 Tempo de Resposta
- Login: < 1 segundo
- Criação de agendamento: < 1 segundo
- Listagem de agendamentos: < 1 segundo
- Cancelamento: < 1 segundo

#### 3.2.2 Recursos do Sistema
- Uso de memória: < 500MB
- Uso de CPU: < 30%
- Espaço em disco: < 100MB

### 3.3 Segurança

#### 3.3.1 Autenticação
- Senhas armazenadas com hash
- Proteção contra SQL injection
- Validação de entrada de dados

#### 3.3.2 Dados
- Persistência local
- Backup automático
- Proteção contra corrupção

### 3.4 Confiabilidade

#### 3.4.1 Disponibilidade
- Sistema disponível 99.9% do tempo
- Recuperação automática de falhas
- Persistência de dados garantida

#### 3.4.2 Robustez
- Tratamento de erros
- Validação de dados
- Prevenção de crashes

## 4. Requisitos de Sistema

### 4.1 Hardware
- Processador: Intel Core i3 ou superior
- Memória RAM: 4GB ou superior
- Espaço em disco: 500MB livre
- Resolução de tela: 1366x768 ou superior

### 4.2 Software
- Sistema operacional: Windows 10 ou superior
- Java JDK 17 ou superior
- SQLite 3

### 4.3 Rede
- Conexão com internet para download inicial de dependências
- Operação offline após instalação

## 5. Restrições

### 5.1 Técnicas
- Desenvolvido em Java
- Interface com Java Swing
- Banco de dados SQLite
- Sem dependências externas além das especificadas

### 5.2 de Negócio
- Sistema para uso pessoal
- Dados armazenados localmente
- Sem compartilhamento de dados

## 6. Requisitos de Manutenção

### 6.1 Código
- Organização modular
- Documentação clara
- Padrões de código seguidos
- Baixo acoplamento

### 6.2 Banco de Dados
- Schema bem definido
- Índices apropriados
- Constraints de integridade
- Backup e recuperação

## 7. Requisitos de Teste

### 7.1 Cobertura
- Testes unitários com JUnit 4.13.2
- Validação de regras de negócio
- Limpeza automática do banco entre testes
- Cobertura dos casos de uso principais:
  - Cadastro de usuário
  - Login
  - Criação de agendamento
  - Validação de data e hora

### 7.2 Qualidade
- Zero bugs críticos
- Máximo 5 bugs não críticos
- Performance dentro dos limites
- Testes automatizados executando com sucesso
- Banco de dados limpo entre testes

## 8. Requisitos de Documentação

### 8.1 Técnica
- Documentação de código
- Diagramas UML
- Manual de instalação
- Manual de desenvolvimento

### 8.2 do Usuário
- Manual do usuário
- Guia de início rápido
- FAQ
- Suporte técnico

## 9. Requisitos de Evolução

### 9.1 Extensibilidade
- Fácil adição de novas funcionalidades
- Modularização do código
- Interfaces bem definidas

### 9.2 Compatibilidade
- Compatível com futuras versões do Java
- Compatível com futuras versões do Windows
- Migração de dados facilitada 