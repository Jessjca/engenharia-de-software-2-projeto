# Plano de Testes

## 1. Introdução

Este documento descreve o plano de testes para o Sistema de Agenda, definindo as estratégias, níveis e tipos de testes necessários para garantir a qualidade do software.

## 2. Objetivos

- Verificar a funcionalidade do sistema
- Validar a interface do usuário
- Garantir a integridade dos dados
- Identificar e corrigir defeitos
- Avaliar a performance

## 3. Estratégia de Testes

### 3.1 Níveis de Teste

#### 3.1.1 Testes Unitários
- Testes das classes individuais
- Cobertura de métodos e funções
- Validação de regras de negócio

#### 3.1.2 Testes de Integração
- Testes entre componentes
- Validação de fluxos de dados
- Verificação de comunicação entre camadas

#### 3.1.3 Testes de Sistema
- Testes end-to-end
- Validação de funcionalidades completas
- Verificação de requisitos não funcionais

### 3.2 Tipos de Teste

#### 3.2.1 Testes Funcionais
- Validação de funcionalidades
- Verificação de regras de negócio
- Testes de casos de uso

#### 3.2.2 Testes de Interface
- Validação da interface gráfica
- Verificação de usabilidade
- Testes de interação do usuário

#### 3.2.3 Testes de Banco de Dados
- Validação de operações CRUD
- Verificação de integridade
- Testes de transações

## 4. Ambiente de Testes

### 4.1 Requisitos
- JDK 17 ou superior
- SQLite 3
- Sistema operacional Windows 10 ou superior

### 4.2 Configuração
- Banco de dados de teste separado
- Dados de teste pré-configurados
- Ambiente isolado de produção

## 5. Casos de Teste

### 5.1 Testes de Usuário

#### 5.1.1 Cadastro de Usuário
```java
@Test
public void testCadastroUsuarioValido() {
    Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
    assertTrue(db.cadastrarUsuario(usuario));
}

@Test
public void testCadastroUsuarioEmailDuplicado() {
    Usuario usuario1 = new Usuario("Teste1", "teste@email.com", "senha123");
    Usuario usuario2 = new Usuario("Teste2", "teste@email.com", "senha456");
    db.cadastrarUsuario(usuario1);
    assertFalse(db.cadastrarUsuario(usuario2));
}
```

#### 5.1.2 Login
```java
@Test
public void testLoginCredenciaisValidas() {
    Usuario usuario = new Usuario("Teste", "teste@email.com", "senha123");
    db.cadastrarUsuario(usuario);
    assertNotNull(db.buscarUsuario("teste@email.com"));
}

@Test
public void testLoginCredenciaisInvalidas() {
    assertNull(db.buscarUsuario("invalido@email.com"));
}
```

### 5.2 Testes de Agendamento

#### 5.2.1 Criação de Agendamento
```java
@Test
public void testCriarAgendamentoValido() {
    Agendamento agendamento = new Agendamento(1, "2024-03-20", "14:00", "Reunião");
    assertTrue(db.criarAgendamento(agendamento));
}

@Test
public void testCriarAgendamentoDataPassada() {
    Agendamento agendamento = new Agendamento(1, "2023-01-01", "14:00", "Reunião");
    assertFalse(db.criarAgendamento(agendamento));
}
```

#### 5.2.2 Listagem de Agendamentos
```java
@Test
public void testListarAgendamentos() {
    List<Agendamento> agendamentos = db.listarAgendamentos(1);
    assertNotNull(agendamentos);
    assertTrue(agendamentos.size() >= 0);
}
```

### 5.3 Testes de Interface

#### 5.3.1 Validação de Campos
```java
@Test
public void testValidacaoCamposLogin() {
    JTextField emailField = new JTextField("teste@email.com");
    JPasswordField senhaField = new JPasswordField("senha123");
    assertTrue(validarCamposLogin(emailField, senhaField));
}

@Test
public void testValidacaoCamposAgendamento() {
    JTextField dataField = new JTextField("2024-03-20");
    JTextField horaField = new JTextField("14:00");
    JTextField descricaoField = new JTextField("Reunião");
    assertTrue(validarCamposAgendamento(dataField, horaField, descricaoField));
}
```

## 6. Procedimentos de Teste

### 6.1 Preparação
1. Configurar ambiente de teste
2. Criar banco de dados de teste
3. Inserir dados iniciais
4. Verificar conexão

### 6.2 Execução
1. Executar testes unitários
2. Executar testes de integração
3. Executar testes de sistema
4. Documentar resultados

### 6.3 Análise
1. Verificar resultados
2. Identificar defeitos
3. Priorizar correções
4. Documentar problemas

## 7. Critérios de Aceitação

### 7.1 Funcionais
- Todas as funcionalidades implementadas
- Regras de negócio atendidas
- Fluxos de dados corretos

### 7.2 Não Funcionais
- Tempo de resposta < 2 segundos
- Interface responsiva
- Dados persistentes

## 8. Ferramentas de Teste

### 8.1 Testes Unitários
- JUnit 5
- Mockito (quando necessário)

### 8.2 Testes de Interface
- Testes manuais
- Checklist de verificação

### 8.3 Banco de Dados
- SQLite Browser
- Scripts de teste

## 9. Cronograma

### 9.1 Fase 1 - Testes Unitários
- Duração: 1 semana
- Foco: Classes individuais

### 9.2 Fase 2 - Testes de Integração
- Duração: 1 semana
- Foco: Componentes e fluxos

### 9.3 Fase 3 - Testes de Sistema
- Duração: 1 semana
- Foco: Funcionalidades completas

## 10. Responsabilidades

### 10.1 Equipe de Testes
- Desenvolvedores
- Testadores
- Analistas de qualidade

### 10.2 Papéis
- Coordenador de testes
- Executores de teste
- Analistas de defeitos

## 11. Documentação

### 11.1 Artefatos
- Casos de teste
- Resultados
- Relatórios de defeitos

### 11.2 Templates
- Plano de teste
- Caso de teste
- Relatório de defeito

## 12. Manutenção

### 12.1 Atualização
- Revisão periódica
- Atualização de casos
- Adaptação a mudanças

### 12.2 Versionamento
- Controle de versão
- Histórico de alterações
- Rastreabilidade 