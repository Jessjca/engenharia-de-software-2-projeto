# Diagramas UML do Sistema de Agenda

Este diretório contém os arquivos fonte dos diagramas UML do sistema. Os diagramas foram criados usando o Draw.io (diagrams.net).

## Como Editar os Diagramas

1. Acesse [draw.io](https://app.diagrams.net/)
2. Abra o arquivo .drawio correspondente ao diagrama que deseja editar
3. Faça as alterações necessárias
4. Salve o arquivo

## Lista de Diagramas

1. **Diagrama de Classes** (`diagrama_classes.drawio`)
   - Representa as classes do sistema e seus relacionamentos
   - Inclui: Usuario, Agendamento, DatabaseManager, Main, TextShadowLabel

2. **Diagrama de Casos de Uso** (`diagrama_casos_uso.drawio`)
   - Mostra as funcionalidades do sistema do ponto de vista do usuário
   - Inclui: Cadastro, Login, Gerenciamento de Agendamentos

3. **Diagrama de Sequência - Login** (`diagrama_sequencia_login.drawio`)
   - Detalha o fluxo de interação durante o processo de login
   - Inclui: Usuário, Main, DatabaseManager

4. **Diagrama de Sequência - Agendamento** (`diagrama_sequencia_agendamento.drawio`)
   - Detalha o fluxo de criação de um novo agendamento
   - Inclui: Usuário, Main, DatabaseManager

5. **Diagrama de Atividade** (`diagrama_atividade.drawio`)
   - Mostra o fluxo principal do sistema
   - Inclui: Inicialização, Login, Cadastro, Agenda

6. **Diagrama de Componentes** (`diagrama_componentes.drawio`)
   - Representa a arquitetura do sistema
   - Inclui: Interface, Lógica, Persistência

7. **Diagrama de Pacotes** (`diagrama_pacotes.drawio`)
   - Mostra a estrutura de pacotes do projeto
   - Inclui: src, main, java, resources

8. **Diagrama de Objetos** (`diagrama_objetos.drawio`)
   - Representa o estado do sistema em tempo de execução
   - Inclui: Sistema, DatabaseManager, Usuario, Agendamento

## Como Exportar para Imagem

1. Abra o diagrama no Draw.io
2. Clique em "File" > "Export As"
3. Selecione o formato desejado (PNG, SVG, etc.)
4. Escolha a qualidade da exportação
5. Clique em "Export"

## Convenções de Nomenclatura

- Arquivos fonte: `diagrama_[tipo].drawio`
- Imagens exportadas: `diagrama_[tipo].png`
- Versões anteriores: `diagrama_[tipo]_v[numero].drawio`

## Manutenção

- Mantenha os diagramas atualizados conforme o código evolui
- Documente alterações significativas no arquivo CHANGELOG.md
- Faça backup dos arquivos fonte antes de grandes alterações 