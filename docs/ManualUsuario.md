# Manual do Usuário - Sistema de Agenda

## 1. Introdução

O Sistema de Agenda é uma aplicação desktop desenvolvida para ajudar você a gerenciar seus compromissos de forma simples e eficiente. Este manual fornece instruções detalhadas sobre como utilizar todas as funcionalidades do sistema.

## 2. Requisitos do Sistema

- Sistema operacional: Windows 10 ou superior
- Java JDK 17 ou superior instalado
- Mínimo de 4GB de memória RAM
- 500MB de espaço em disco

## 3. Instalação

### 3.1 Primeira Execução

1. Execute o arquivo `baixar_driver.bat` para baixar as dependências necessárias
2. Aguarde a conclusão do download
3. Execute o arquivo `compilar.bat` para iniciar o sistema

### 3.2 Execuções Subsequentes

- Execute apenas o arquivo `compilar.bat` para iniciar o sistema

## 4. Funcionalidades

### 4.1 Tela de Login

![Tela de Login](images/login.png)

- **Email**: Digite seu endereço de email cadastrado
- **Senha**: Digite sua senha
- **Botão Login**: Clique para acessar o sistema
- **Botão Cadastrar**: Clique para criar uma nova conta

### 4.2 Cadastro de Usuário

![Tela de Cadastro](images/cadastro.png)

- **Nome**: Digite seu nome completo
- **Email**: Digite um endereço de email válido
- **Senha**: Digite uma senha com no mínimo 6 caracteres
- **Botão Cadastrar**: Clique para criar sua conta
- **Botão Voltar**: Retorna à tela de login

### 4.3 Tela Principal (Agenda)

![Tela Principal](images/agenda.png)

- **Lista de Agendamentos**: Exibe todos os seus compromissos
- **Botão Novo Agendamento**: Cria um novo compromisso
- **Botão Cancelar**: Remove um agendamento selecionado
- **Botão Sair**: Encerra sua sessão

### 4.4 Novo Agendamento

![Novo Agendamento](images/novo_agendamento.png)

- **Data**: Selecione a data do compromisso
- **Hora**: Digite a hora no formato HH:mm
- **Descrição**: Digite uma descrição do compromisso
- **Botão Criar**: Salva o novo agendamento
- **Botão Cancelar**: Retorna à tela principal

## 5. Guia de Uso

### 5.1 Criando uma Conta

1. Na tela de login, clique em "Cadastrar"
2. Preencha seus dados:
   - Nome completo
   - Email válido
   - Senha (mínimo 6 caracteres)
3. Clique em "Cadastrar"
4. Se o cadastro for bem-sucedido, você será redirecionado para o login

### 5.2 Fazendo Login

1. Digite seu email cadastrado
2. Digite sua senha
3. Clique em "Login"
4. Se as credenciais estiverem corretas, você será redirecionado para a agenda

### 5.3 Criando um Agendamento

1. Na tela principal, clique em "Novo Agendamento"
2. Selecione a data do compromisso
3. Digite a hora no formato HH:mm
4. Digite uma descrição do compromisso
5. Clique em "Criar"
6. O agendamento será adicionado à sua lista

### 5.4 Visualizando Agendamentos

- Todos os seus agendamentos são exibidos na tela principal
- Os agendamentos são ordenados por data e hora
- Cada agendamento mostra:
  - Data
  - Hora
  - Descrição

### 5.5 Cancelando um Agendamento

1. Selecione o agendamento na lista
2. Clique em "Cancelar"
3. Confirme o cancelamento na janela de diálogo
4. O agendamento será removido da lista

## 6. Dicas e Truques

### 6.1 Formato de Data e Hora

- Data: Use o formato DD/MM/AAAA
- Hora: Use o formato HH:mm (24 horas)

### 6.2 Organização

- Crie agendamentos com descrições claras
- Verifique sua agenda regularmente
- Cancele compromissos que não serão realizados

### 6.3 Segurança

- Mantenha sua senha em segurança
- Não compartilhe suas credenciais
- Faça logout ao terminar de usar o sistema

## 7. Solução de Problemas

### 7.1 Problemas Comuns

#### Não consigo fazer login
- Verifique se o email está correto
- Confirme se a senha está correta
- Tente criar uma nova conta se necessário

#### Agendamento não aparece na lista
- Verifique se a data não é anterior à data atual
- Confirme se o formato da hora está correto
- Tente criar o agendamento novamente

#### Sistema não inicia
- Verifique se o Java está instalado corretamente
- Confirme se todas as dependências foram baixadas
- Tente executar o `baixar_driver.bat` novamente

### 7.2 Mensagens de Erro

#### "Email já cadastrado"
- Use um email diferente
- Faça login com a conta existente

#### "Data inválida"
- Use o formato DD/MM/AAAA
- Não use datas passadas

#### "Hora inválida"
- Use o formato HH:mm
- Use o sistema de 24 horas

## 8. Suporte

### 8.1 Contato

Para suporte técnico ou dúvidas:
- Email: suporte@sistemaagenda.com
- Telefone: (11) 1234-5678

### 8.2 Atualizações

O sistema é atualizado periodicamente. Para verificar atualizações:
1. Feche o sistema
2. Execute o `baixar_driver.bat`
3. Execute o `compilar.bat`

## 9. Glossário

- **Agendamento**: Compromisso registrado no sistema
- **Login**: Acesso ao sistema com email e senha
- **Cadastro**: Criação de uma nova conta
- **Cancelamento**: Remoção de um agendamento
- **Sessão**: Período de uso do sistema após login

## 10. Índice

1. [Introdução](#1-introdução)
2. [Requisitos do Sistema](#2-requisitos-do-sistema)
3. [Instalação](#3-instalação)
4. [Funcionalidades](#4-funcionalidades)
5. [Guia de Uso](#5-guia-de-uso)
6. [Dicas e Truques](#6-dicas-e-truques)
7. [Solução de Problemas](#7-solução-de-problemas)
8. [Suporte](#8-suporte)
9. [Glossário](#9-glossário) 