# Histórias de Usuário e Cenários de Teste

## 1. Histórias de Usuário

### 1.1 Cadastro de Usuário
**Como** um novo usuário  
**Quero** me cadastrar no sistema  
**Para** poder acessar e gerenciar meus agendamentos

**Critérios de Aceitação:**
- Devo poder informar nome, email e senha
- O email não pode estar em uso
- A senha deve ter no mínimo 6 caracteres
- Devo receber confirmação do cadastro

### 1.2 Login
**Como** um usuário cadastrado  
**Quero** fazer login no sistema  
**Para** acessar minha conta e meus agendamentos

**Critérios de Aceitação:**
- Devo poder informar email e senha
- O sistema deve validar minhas credenciais
- Devo ser redirecionado para a tela principal após login bem-sucedido
- Devo receber mensagem de erro se as credenciais estiverem incorretas

### 1.3 Criação de Agendamento
**Como** um usuário logado  
**Quero** criar um novo agendamento  
**Para** registrar meus compromissos

**Critérios de Aceitação:**
- Devo poder informar data, hora e descrição
- O sistema deve validar o formato da data e hora
- Não deve permitir agendamentos em datas passadas
- Devo receber confirmação do agendamento criado

### 1.4 Visualização de Agendamentos
**Como** um usuário logado  
**Quero** ver meus agendamentos  
**Para** acompanhar meus compromissos

**Critérios de Aceitação:**
- Devo ver todos os meus agendamentos
- Os agendamentos devem estar ordenados por data e hora
- Devo ver data, hora e descrição de cada agendamento
- A lista deve ser atualizada automaticamente

### 1.5 Cancelamento de Agendamento
**Como** um usuário logado  
**Quero** cancelar um agendamento  
**Para** remover compromissos que não serão realizados

**Critérios de Aceitação:**
- Devo poder selecionar um agendamento para cancelar
- O sistema deve pedir confirmação do cancelamento
- O agendamento deve ser removido da lista após cancelamento
- Devo receber confirmação do cancelamento

## 2. Cenários de Teste

### 2.1 Cadastro de Usuário

#### CT1 - Cadastro com Dados Válidos
**Pré-condições:**
- Sistema iniciado
- Email não cadastrado

**Passos:**
1. Acessar tela de cadastro
2. Preencher nome
3. Preencher email válido
4. Preencher senha com 6 ou mais caracteres
5. Clicar em "Cadastrar"

**Resultado Esperado:**
- Usuário cadastrado com sucesso
- Mensagem de confirmação exibida
- Redirecionamento para tela de login

#### CT2 - Cadastro com Email Duplicado
**Pré-condições:**
- Sistema iniciado
- Email já cadastrado

**Passos:**
1. Acessar tela de cadastro
2. Preencher nome
3. Preencher email já cadastrado
4. Preencher senha
5. Clicar em "Cadastrar"

**Resultado Esperado:**
- Mensagem de erro informando email já cadastrado
- Dados mantidos no formulário
- Usuário permanece na tela de cadastro

### 2.2 Login

#### CT3 - Login com Credenciais Válidas
**Pré-condições:**
- Sistema iniciado
- Usuário cadastrado

**Passos:**
1. Acessar tela de login
2. Preencher email cadastrado
3. Preencher senha correta
4. Clicar em "Login"

**Resultado Esperado:**
- Login realizado com sucesso
- Redirecionamento para tela principal
- Dados do usuário carregados

#### CT4 - Login com Senha Incorreta
**Pré-condições:**
- Sistema iniciado
- Usuário cadastrado

**Passos:**
1. Acessar tela de login
2. Preencher email cadastrado
3. Preencher senha incorreta
4. Clicar em "Login"

**Resultado Esperado:**
- Mensagem de erro informando credenciais inválidas
- Senha limpa
- Usuário permanece na tela de login

### 2.3 Criação de Agendamento

#### CT5 - Criar Agendamento Válido
**Pré-condições:**
- Usuário logado
- Data futura

**Passos:**
1. Acessar tela de novo agendamento
2. Preencher data futura
3. Preencher hora válida
4. Preencher descrição
5. Clicar em "Criar"

**Resultado Esperado:**
- Agendamento criado com sucesso
- Mensagem de confirmação exibida
- Agendamento aparece na lista

#### CT6 - Criar Agendamento com Data Passada
**Pré-condições:**
- Usuário logado

**Passos:**
1. Acessar tela de novo agendamento
2. Preencher data passada
3. Preencher hora
4. Preencher descrição
5. Clicar em "Criar"

**Resultado Esperado:**
- Mensagem de erro informando data inválida
- Dados mantidos no formulário
- Agendamento não é criado

### 2.4 Visualização de Agendamentos

#### CT7 - Listar Agendamentos
**Pré-condições:**
- Usuário logado
- Agendamentos cadastrados

**Passos:**
1. Acessar tela de agendamentos
2. Verificar lista

**Resultado Esperado:**
- Todos os agendamentos são exibidos
- Ordenados por data e hora
- Informações completas visíveis

### 2.5 Cancelamento de Agendamento

#### CT8 - Cancelar Agendamento
**Pré-condições:**
- Usuário logado
- Agendamento existente

**Passos:**
1. Acessar tela de agendamentos
2. Selecionar agendamento
3. Clicar em "Cancelar"
4. Confirmar cancelamento

**Resultado Esperado:**
- Agendamento removido da lista
- Mensagem de confirmação exibida
- Lista atualizada automaticamente 