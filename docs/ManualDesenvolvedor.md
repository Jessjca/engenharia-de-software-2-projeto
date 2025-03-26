# Manual do Desenvolvedor - Sistema de Agendamento de Compromissos

## 1. Introdução
Este manual fornece informações técnicas para desenvolvedores que trabalham no Sistema de Agendamento de Compromissos.

## 2. Ambiente de Desenvolvimento

### 2.1 Requisitos
- JDK 11 ou superior
- IDE recomendada: IntelliJ IDEA ou Eclipse
- Git para controle de versão
- SQLite para banco de dados

### 2.2 Configuração do Ambiente
1. Clone o repositório:
   ```bash
   git clone [URL_DO_REPOSITORIO]
   ```

2. Configure o JDK:
   - Instale o JDK 11 ou superior
   - Configure a variável JAVA_HOME
   - Adicione o JDK ao PATH do sistema

3. Configure o IDE:
   - Importe o projeto como projeto Java
   - Configure o JDK no projeto
   - Configure o encoding UTF-8

## 3. Estrutura do Projeto

### 3.1 Organização de Arquivos
```
src/
├── main/
│   └── java/
│       ├── model/      # Classes de modelo
│       ├── controller/ # Controladores
│       └── view/       # Interface gráfica
├── test/
│   └── java/          # Testes unitários
└── resources/         # Recursos da aplicação
```

### 3.2 Padrões de Código
- Siga o padrão de nomenclatura Java
- Use camelCase para métodos e variáveis
- Use PascalCase para classes
- Documente todas as classes e métodos públicos
- Mantenha métodos pequenos e focados

## 4. Arquitetura

### 4.1 Padrão MVC
O sistema segue o padrão MVC:
- **Model**: Classes em `model/`
- **View**: Classes em `view/`
- **Controller**: Classes em `controller/`

### 4.2 Classes Principais
- `Usuario`: Modelo de usuário
- `Agendamento`: Modelo de agendamento
- `DatabaseManager`: Gerenciamento do banco de dados
- `MainController`: Controlador principal
- `MainView`: Interface principal
- `BackgroundPanel`: Painel com imagem de fundo

## 5. Banco de Dados

### 5.1 Estrutura
O banco de dados SQLite contém duas tabelas:
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

### 5.2 Acesso ao Banco
- Use a classe `DatabaseManager` para operações no banco
- Implemente tratamento de exceções adequado
- Use prepared statements para prevenir SQL injection

## 6. Testes

### 6.1 Testes Unitários
- Localização: `src/test/java/`
- Use JUnit 4.13.2
- Teste cada classe individualmente
- Mantenha os testes independentes

### 6.2 Executando Testes
```bash
# Compilar testes
javac -cp "bin;lib/*" -d bin src/test/java/model/*.java src/test/java/controller/*.java src/test/java/view/*.java

# Executar testes
java -cp "bin;lib/*" org.junit.runner.JUnitCore model.UsuarioTest model.AgendamentoTest model.DatabaseManagerTest controller.MainControllerTest view.MainViewTest
```

## 7. Interface Gráfica

### 7.1 Componentes
- Use Swing para interface gráfica
- Siga o padrão de layout GridBagLayout
- Mantenha a interface responsiva
- Use cores e fontes consistentes

### 7.2 Imagens e Recursos
- Armazene imagens em `src/main/resources/`
- Use `BackgroundPanel` para imagens de fundo
- Mantenha os recursos organizados

## 8. Compilação e Execução

### 8.1 Compilação
```bash
javac -cp "lib/*" -d bin src/main/java/model/*.java src/main/java/controller/*.java src/main/java/view/*.java
```

### 8.2 Execução
```bash
java -cp "bin;lib/*" view.MainView
```

## 9. Manutenção

### 9.1 Logs
- Use `System.out.println` para debug
- Implemente logging adequado em produção
- Mantenha logs organizados e rotacionados

### 9.2 Tratamento de Erros
- Use try-catch para exceções
- Implemente mensagens de erro claras
- Faça rollback de transações quando necessário

## 10. Controle de Versão

### 10.1 Git
- Use branches para novas funcionalidades
- Faça commits frequentes e descritivos
- Mantenha o histórico limpo

### 10.2 Fluxo de Trabalho
1. Crie uma branch para a feature
2. Desenvolva e teste
3. Faça commit das alterações
4. Crie um pull request
5. Após revisão, faça merge

## 11. Segurança

### 11.1 Boas Práticas
- Criptografe senhas
- Valide todas as entradas
- Use prepared statements
- Implemente timeout de sessão

### 11.2 Vulnerabilidades Comuns
- SQL Injection
- XSS (Cross-Site Scripting)
- CSRF (Cross-Site Request Forgery)
- Injeção de código

## 12. Performance

### 12.1 Otimizações
- Use connection pool
- Implemente cache
- Otimize consultas SQL
- Minimize operações de I/O

### 12.2 Monitoramento
- Monitore tempo de resposta
- Verifique uso de memória
- Acompanhe uso do banco de dados
- Analise logs de erro 