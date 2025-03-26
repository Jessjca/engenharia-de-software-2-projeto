# Plano de Testes - Sistema de Agendamento de Compromissos

## 1. Introdução
Este documento descreve o plano de testes para o Sistema de Agendamento de Compromissos, desenvolvido seguindo a arquitetura MVC (Model-View-Controller). O plano abrange testes unitários e de integração para cada camada do sistema.

## 2. Objetivos
- Validar o funcionamento correto de cada componente do sistema
- Garantir a integração adequada entre as camadas MVC
- Identificar e corrigir defeitos no código
- Manter a qualidade do software durante o desenvolvimento
- Validar a separação de responsabilidades da arquitetura MVC

## 3. Estratégia de Testes

### 3.1 Testes por Camada
- **Model**: Testes unitários das classes de modelo e acesso a dados
- **View**: Testes de interface e componentes visuais
- **Controller**: Testes de lógica de negócio e integração entre Model e View

### 3.2 Tipos de Testes
- Testes unitários
- Testes de integração
- Testes de interface

## 4. Ambiente de Testes

### 4.1 Requisitos
- JDK 11 ou superior
- JUnit 4.13.2
- SQLite para testes
- IDE com suporte a testes

### 4.2 Configuração
- Banco de dados SQLite para testes
- Dependências do JUnit configuradas
- Ambiente isolado para testes

## 5. Casos de Teste

### 5.1 Testes do Model

#### 5.1.1 UsuarioTest
```java
@Test
public void testCriarUsuario() {
    Usuario usuario = new Usuario();
    usuario.setNome("Teste");
    usuario.setEmail("teste@email.com");
    usuario.setSenha("123456");
    
    assertEquals("Teste", usuario.getNome());
    assertEquals("teste@email.com", usuario.getEmail());
    assertEquals("123456", usuario.getSenha());
}

@Test
public void testValidarEmail() {
    Usuario usuario = new Usuario();
    usuario.setEmail("email.invalido");
    assertFalse(usuario.validarEmail());
    
    usuario.setEmail("email@valido.com");
    assertTrue(usuario.validarEmail());
}

@Test
public void testValidarSenha() {
    Usuario usuario = new Usuario();
    usuario.setSenha("123");
    assertFalse(usuario.validarSenha());
    
    usuario.setSenha("123456");
    assertTrue(usuario.validarSenha());
}
```

#### 5.1.2 AgendamentoTest
```java
@Test
public void testCriarAgendamento() {
    Agendamento agendamento = new Agendamento();
    agendamento.setUsuarioId(1);
    agendamento.setData(new Date());
    agendamento.setHora("14:00");
    agendamento.setDescricao("Reunião");
    
    assertEquals(1, agendamento.getUsuarioId());
    assertEquals("14:00", agendamento.getHora());
    assertEquals("Reunião", agendamento.getDescricao());
}

@Test
public void testValidarData() {
    Agendamento agendamento = new Agendamento();
    Date dataPassada = new Date(System.currentTimeMillis() - 86400000);
    agendamento.setData(dataPassada);
    assertFalse(agendamento.validarData());
    
    Date dataFutura = new Date(System.currentTimeMillis() + 86400000);
    agendamento.setData(dataFutura);
    assertTrue(agendamento.validarData());
}
```

#### 5.1.3 DatabaseManagerTest
```java
@Test
public void testCadastrarUsuario() {
    DatabaseManager db = new DatabaseManager();
    Usuario usuario = new Usuario();
    usuario.setNome("Teste");
    usuario.setEmail("teste@email.com");
    usuario.setSenha("123456");
    
    assertTrue(db.cadastrarUsuario(usuario));
}

@Test
public void testBuscarUsuario() {
    DatabaseManager db = new DatabaseManager();
    Usuario usuario = db.buscarUsuario("teste@email.com");
    assertNotNull(usuario);
    assertEquals("Teste", usuario.getNome());
}

@Test
public void testCriarAgendamento() {
    DatabaseManager db = new DatabaseManager();
    Agendamento agendamento = new Agendamento();
    agendamento.setUsuarioId(1);
    agendamento.setData(new Date());
    agendamento.setHora("14:00");
    agendamento.setDescricao("Reunião");
    
    assertTrue(db.criarAgendamento(agendamento));
}
```

### 5.2 Testes do Controller

#### 5.2.1 MainControllerTest
```java
@Test
public void testLogin() {
    MainController controller = new MainController();
    assertTrue(controller.login("teste@email.com", "123456"));
    assertFalse(controller.login("email@invalido.com", "senha"));
}

@Test
public void testCriarAgendamento() {
    MainController controller = new MainController();
    Date data = new Date();
    assertTrue(controller.criarAgendamento(1, data, "14:00", "Reunião"));
    assertFalse(controller.criarAgendamento(1, data, "20:00", "Reunião"));
}

@Test
public void testExcluirAgendamento() {
    MainController controller = new MainController();
    assertTrue(controller.excluirAgendamento(1));
    assertFalse(controller.excluirAgendamento(999));
}
```

### 5.3 Testes da View

#### 5.3.1 MainViewTest
```java
@Test
public void testInicializacao() {
    MainView view = new MainView();
    assertNotNull(view);
    assertTrue(view.isVisible());
}

@Test
public void testComponentesLogin() {
    MainView view = new MainView();
    JPanel loginPanel = view.criarPainelLogin();
    assertNotNull(loginPanel);
    assertTrue(loginPanel.isVisible());
}

@Test
public void testComponentesAgendamento() {
    MainView view = new MainView();
    JPanel agendamentoPanel = view.criarPainelAgendamento();
    assertNotNull(agendamentoPanel);
    assertTrue(agendamentoPanel.isVisible());
}
```

## 6. Procedimentos de Execução

### 6.1 Execução dos Testes
```bash
# Compilar testes
javac -cp "bin;lib/*" -d bin src/test/java/model/*.java src/test/java/controller/*.java src/test/java/view/*.java

# Executar testes
java -cp "bin;lib/*" org.junit.runner.JUnitCore model.UsuarioTest model.AgendamentoTest model.DatabaseManagerTest controller.MainControllerTest view.MainViewTest
```

### 6.2 Ordem de Execução
1. Testes do Model
2. Testes do Controller
3. Testes da View
4. Testes de Integração

## 7. Critérios de Aceitação
- Todos os testes devem passar
- Cobertura de código mínima de 80%
- Separação clara de responsabilidades entre as camadas MVC
- Interface responsiva e funcional
- Validações de dados funcionando corretamente

## 8. Ferramentas de Teste
- JUnit 4.13.2 para testes unitários e de integração
- SQLite para banco de dados de teste

## 9. Cronograma
- Desenvolvimento dos testes: 1 semana
- Execução inicial: 2 dias
- Correções e ajustes: 3 dias

## 10. Responsabilidades
- Desenvolvedores: Implementação dos testes
- QA: Revisão e validação
- Scrum Master: Acompanhamento do progresso

## 11. Documentação
- Testes documentados com comentários
- Relatórios de execução
- Documentação de casos de teste mantida atualizada

## 12. Manutenção
- Atualização dos testes conforme novas funcionalidades
- Revisão periódica da cobertura de testes
- Ajustes necessários identificados durante execução 