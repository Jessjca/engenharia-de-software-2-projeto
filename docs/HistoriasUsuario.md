# Histórias de Usuário - Sistema de Agendamento de Compromissos

## 1. Histórias de Usuário

### 1.1 Cadastro de Usuário
**Como** um novo usuário do sistema  
**Quero** poder criar uma conta  
**Para** ter acesso ao sistema de agendamentos

**Critérios de Aceitação**:
- O usuário deve fornecer nome, email e senha
- O email deve ser único no sistema
- A senha deve ter no mínimo 6 caracteres
- O sistema deve validar os dados antes de criar a conta
- Após o cadastro, o usuário deve ser redirecionado para a tela de login

### 1.2 Login
**Como** um usuário cadastrado  
**Quero** poder fazer login no sistema  
**Para** acessar minhas funcionalidades

**Critérios de Aceitação**:
- O usuário deve fornecer email e senha
- O sistema deve validar as credenciais
- Em caso de credenciais inválidas, exibir mensagem de erro
- Após login bem-sucedido, exibir a tela principal

### 1.3 Criação de Agendamento
**Como** um usuário logado  
**Quero** poder criar um novo agendamento  
**Para** registrar meus compromissos

**Critérios de Aceitação**:
- O usuário deve fornecer data, hora e descrição
- A data não pode ser anterior à data atual
- O horário deve estar dentro do horário comercial (8h às 18h)
- O sistema deve validar os dados antes de criar o agendamento
- Após criar, o agendamento deve aparecer na lista

### 1.4 Visualização de Agendamentos
**Como** um usuário logado  
**Quero** poder ver meus agendamentos  
**Para** acompanhar meus compromissos

**Critérios de Aceitação**:
- Listar todos os agendamentos do usuário
- Ordenar por data e hora
- Exibir data, hora e descrição de cada agendamento
- Permitir filtrar por data
- Atualizar a lista automaticamente após alterações

### 1.5 Cancelamento de Agendamento
**Como** um usuário logado  
**Quero** poder cancelar um agendamento  
**Para** remover compromissos que não serão realizados

**Critérios de Aceitação**:
- Permitir selecionar um agendamento para cancelar
- Solicitar confirmação antes do cancelamento
- Apenas o usuário que criou pode cancelar
- Remover o agendamento da lista após cancelamento
- Atualizar a interface após o cancelamento

## 2. Cenários de Teste

### 2.1 Cadastro de Usuário

#### Cenário 1: Cadastro bem-sucedido
1. Usuário acessa a tela de cadastro
2. Preenche nome, email e senha válidos
3. Clica em "Cadastrar"
4. Sistema valida os dados
5. Sistema cria a conta
6. Sistema redireciona para login

#### Cenário 2: Email já cadastrado
1. Usuário acessa a tela de cadastro
2. Preenche email já existente
3. Clica em "Cadastrar"
4. Sistema exibe mensagem de erro
5. Sistema mantém na tela de cadastro

### 2.2 Login

#### Cenário 1: Login bem-sucedido
1. Usuário acessa a tela de login
2. Preenche credenciais corretas
3. Clica em "Entrar"
4. Sistema valida as credenciais
5. Sistema exibe tela principal

#### Cenário 2: Credenciais inválidas
1. Usuário acessa a tela de login
2. Preenche credenciais incorretas
3. Clica em "Entrar"
4. Sistema exibe mensagem de erro
5. Sistema mantém na tela de login

### 2.3 Criação de Agendamento

#### Cenário 1: Agendamento válido
1. Usuário acessa tela de novo agendamento
2. Preenche data futura
3. Preenche hora dentro do horário comercial
4. Preenche descrição
5. Clica em "Salvar"
6. Sistema valida os dados
7. Sistema cria o agendamento
8. Sistema atualiza a lista

#### Cenário 2: Data inválida
1. Usuário acessa tela de novo agendamento
2. Preenche data passada
3. Preenche outros dados
4. Clica em "Salvar"
5. Sistema exibe mensagem de erro
6. Sistema mantém na tela de agendamento

### 2.4 Visualização de Agendamentos

#### Cenário 1: Listar todos
1. Usuário acessa tela de agendamentos
2. Sistema carrega lista
3. Sistema exibe agendamentos ordenados
4. Usuário visualiza os dados

#### Cenário 2: Filtrar por data
1. Usuário acessa tela de agendamentos
2. Seleciona uma data
3. Sistema filtra agendamentos
4. Sistema exibe apenas agendamentos da data

### 2.5 Cancelamento de Agendamento

#### Cenário 1: Cancelamento confirmado
1. Usuário seleciona agendamento
2. Clica em "Cancelar"
3. Sistema exibe confirmação
4. Usuário confirma
5. Sistema remove agendamento
6. Sistema atualiza lista

#### Cenário 2: Cancelamento cancelado
1. Usuário seleciona agendamento
2. Clica em "Cancelar"
3. Sistema exibe confirmação
4. Usuário cancela
5. Sistema mantém agendamento
6. Sistema mantém lista atual

## 3. Regras de Negócio

### 3.1 Validações
- Email deve ter formato válido
- Senha deve ter mínimo de 6 caracteres
- Data não pode ser anterior à atual
- Hora deve estar entre 8h e 18h
- Descrição não pode estar vazia

### 3.2 Permissões
- Apenas usuário logado pode criar agendamentos
- Apenas criador pode cancelar agendamento
- Usuário não pode ver agendamentos de outros

### 3.3 Regras de Negócio Específicas
- Máximo de 5 agendamentos por dia
- Intervalo mínimo de 1 hora entre agendamentos
- Agendamentos não podem ser criados em feriados
- Agendamentos não podem ser criados no passado 