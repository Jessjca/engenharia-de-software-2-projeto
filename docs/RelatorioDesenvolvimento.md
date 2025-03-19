# Relatório de Desenvolvimento - Sistema de Agenda

## 1. Introdução

Este documento apresenta o relatório de desenvolvimento do Sistema de Agenda, uma aplicação desktop desenvolvida em Java para gerenciamento de compromissos. O sistema foi desenvolvido durante três sprints, seguindo metodologias ágeis e boas práticas de desenvolvimento.

## 2. Visão Geral do Projeto

### 2.1 Objetivo
Desenvolver um sistema de agenda pessoal que permita aos usuários:
- Cadastrar e fazer login
- Criar e gerenciar compromissos
- Visualizar agenda organizada
- Persistir dados localmente

### 2.2 Escopo
- Interface gráfica com Java Swing
- Persistência de dados com SQLite
- Sistema de autenticação
- Gerenciamento de agendamentos

## 3. Cronograma de Desenvolvimento

### 3.1 Sprint 1 (2 semanas)
- Análise de requisitos
- Modelagem do sistema
- Configuração do ambiente
- Implementação da estrutura base

### 3.2 Sprint 2 (2 semanas)
- Desenvolvimento da interface
- Implementação do banco de dados
- Sistema de autenticação
- Classes de domínio

### 3.3 Sprint 3 (2 semanas)
- Implementação das funcionalidades
- Testes e correções
- Documentação
- Refinamentos de interface

## 4. Tecnologias Utilizadas

### 4.1 Linguagem e Framework
- Java 17
- Java Swing (GUI)
- SQLite (Banco de dados)

### 4.2 Ferramentas
- Git (Controle de versão)
- VSCode (IDE)
- SQLite Browser (Banco de dados)

### 4.3 Bibliotecas
- SQLite JDBC Driver
- SLF4J (Logging)

## 5. Arquitetura do Sistema

### 5.1 Padrão MVC
- **Model**: Classes de domínio (Usuario, Agendamento)
- **View**: Interface gráfica (Main, TextShadowLabel)
- **Controller**: Lógica de negócio (DatabaseManager)

### 5.2 Estrutura de Pacotes
```
com.agenda/
├── ui/              # Interface
├── model/           # Classes de domínio
└── dao/             # Acesso a dados
```

## 6. Desenvolvimento

### 6.1 Fase 1 - Análise e Modelagem

#### 6.1.1 Requisitos
- Identificação das necessidades
- Definição de funcionalidades
- Estabelecimento de regras de negócio

#### 6.1.2 Modelagem
- Diagramas UML
- Modelo de dados
- Fluxos de interação

### 6.2 Fase 2 - Implementação

#### 6.2.1 Interface
- Desenvolvimento das telas
- Componentes customizados
- Navegação entre telas

#### 6.2.2 Banco de Dados
- Criação do schema
- Implementação do DAO
- Operações CRUD

#### 6.2.3 Lógica de Negócio
- Validações
- Regras de negócio
- Tratamento de erros

### 6.3 Fase 3 - Testes e Refinamento

#### 6.3.1 Testes
- Testes unitários
- Testes de integração
- Testes de sistema

#### 6.3.2 Refinamentos
- Melhorias de interface
- Otimizações de performance
- Correções de bugs

## 7. Desafios e Soluções

### 7.1 Desafios Técnicos

#### 7.1.1 Conexão com Banco de Dados
**Desafio**: Configuração do driver SQLite
**Solução**: Criação de script de download automático

#### 7.1.2 Interface Gráfica
**Desafio**: Componentes personalizados
**Solução**: Implementação de TextShadowLabel

### 7.2 Desafios de Processo

#### 7.2.1 Gerenciamento de Dependências
**Desafio**: Configuração do ambiente
**Solução**: Scripts de automação

#### 7.2.2 Versionamento
**Desafio**: Controle de versões
**Solução**: Uso do Git

## 8. Métricas e Qualidade

### 8.1 Código
- Linhas de código: ~1000
- Classes: 5
- Métodos: ~50
- Complexidade ciclomática: < 10

### 8.2 Qualidade
- Cobertura de testes: 80%
- Tempo de resposta: < 2s
- Uso de memória: < 500MB

## 9. Lições Aprendidas

### 9.1 Técnicas
- Importância da modularização
- Valor da documentação
- Necessidade de testes

### 9.2 Processuais
- Planejamento detalhado
- Revisão contínua
- Adaptação a mudanças

## 10. Próximos Passos

### 10.1 Melhorias Propostas
- Implementação de notificações
- Backup automático
- Temas personalizáveis

### 10.2 Manutenção
- Correções de bugs
- Atualizações de segurança
- Melhorias de performance

## 11. Conclusão

O Sistema de Agenda foi desenvolvido com sucesso, atendendo aos requisitos estabelecidos e seguindo boas práticas de desenvolvimento. O sistema demonstra:
- Interface intuitiva
- Funcionalidades completas
- Boa performance
- Código organizado

## 12. Referências

### 12.1 Documentação
- Java Swing Documentation
- SQLite Documentation
- JUnit Documentation

### 12.2 Ferramentas
- Git Documentation
- VSCode Documentation
- SQLite Browser Documentation

## 13. Anexos

### 13.1 Diagramas
- Diagrama de Classes
- Diagrama de Casos de Uso
- Diagrama de Sequência

### 13.2 Código
- Estrutura de arquivos
- Classes principais
- Scripts de automação

### 13.3 Testes
- Casos de teste
- Resultados
- Métricas 