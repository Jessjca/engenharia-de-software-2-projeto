# Diagramas UML

Este documento descreve os diagramas UML do Sistema de Agenda. As imagens dos diagramas estão disponíveis na pasta `docs/diagramas/imagens/`.

## 1. Diagrama de Classes

![Diagrama de Classes](diagramas/imagens/diagrama_classes.png)

O diagrama de classes representa a estrutura estática do sistema, mostrando as classes principais e seus relacionamentos:

- **Classes Principais**:
  - `Usuario`: Representa um usuário do sistema
  - `Agendamento`: Representa um compromisso
  - `DatabaseManager`: Gerencia o acesso ao banco de dados
  - `Main`: Interface principal do sistema
  - `TextShadowLabel`: Componente customizado para labels

- **Relacionamentos**:
  - Usuário tem vários Agendamentos (1:N)
  - DatabaseManager gerencia Usuários e Agendamentos
  - Main utiliza DatabaseManager e TextShadowLabel

## 2. Diagrama de Casos de Uso

![Diagrama de Casos de Uso](diagramas/imagens/diagrama_casos_uso.png)

O diagrama de casos de uso mostra as funcionalidades do sistema do ponto de vista do usuário:

- **Casos de Uso Principais**:
  - Cadastrar novo usuário
  - Realizar login
  - Criar agendamento
  - Visualizar agendamentos
  - Cancelar agendamento

## 3. Diagrama de Sequência - Login

![Diagrama de Sequência - Login](diagramas/imagens/diagrama_sequencia_login.png)

O diagrama de sequência do login mostra a interação entre os componentes durante o processo de autenticação:

1. Usuário preenche credenciais
2. Main solicita validação ao DatabaseManager
3. DatabaseManager verifica credenciais
4. Sistema redireciona para agenda ou exibe erro

## 4. Diagrama de Sequência - Criação de Agendamento

![Diagrama de Sequência - Agendamento](diagramas/imagens/diagrama_sequencia_agendamento.png)

O diagrama de sequência da criação de agendamento mostra o fluxo de criação de um novo compromisso:

1. Usuário preenche dados do agendamento
2. Main valida os dados
3. DatabaseManager salva o agendamento
4. Interface é atualizada com o novo agendamento

## 5. Diagrama de Atividade - Fluxo Principal

![Diagrama de Atividade](diagramas/imagens/diagrama_atividade.png)

O diagrama de atividade mostra o fluxo principal do sistema:

1. Inicialização do sistema
2. Tela de login
3. Opções de cadastro ou acesso
4. Gerenciamento de agendamentos
5. Logout

## 6. Diagrama de Componentes

![Diagrama de Componentes](diagramas/imagens/diagrama_componentes.png)

O diagrama de componentes representa a arquitetura do sistema:

- **Componentes Principais**:
  - Interface Gráfica (Java Swing)
  - Lógica de Negócio
  - Persistência de Dados (SQLite)

## 7. Diagrama de Pacotes

![Diagrama de Pacotes](diagramas/imagens/diagrama_pacotes.png)

O diagrama de pacotes mostra a estrutura de diretórios do projeto:

- `src/main/java/`: Classes Java
- `src/main/resources/`: Recursos do sistema

## 8. Diagrama de Objetos - Estado do Sistema

![Diagrama de Objetos](diagramas/imagens/diagrama_objetos.png)

O diagrama de objetos representa o estado do sistema em tempo de execução:

- Sistema com DatabaseManager ativo
- Usuário atual logado
- Lista de agendamentos do usuário

## Notas Técnicas

Os diagramas foram criados usando o Draw.io (diagrams.net) e estão disponíveis em:
- Arquivos fonte: `docs/diagramas/fonte/`
- Imagens exportadas: `docs/diagramas/imagens/`

Para editar os diagramas:
1. Acesse [draw.io](https://app.diagrams.net/)
2. Abra o arquivo .drawio correspondente
3. Faça as alterações necessárias
4. Exporte como imagem PNG 