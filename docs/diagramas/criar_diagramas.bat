@echo off
echo Criando estrutura de diretórios para diagramas UML...

:: Criar diretório de diagramas se não existir
if not exist "diagramas" mkdir diagramas

:: Criar diretório para arquivos fonte
if not exist "diagramas\fonte" mkdir diagramas\fonte

:: Criar diretório para imagens exportadas
if not exist "diagramas\imagens" mkdir diagramas\imagens

:: Criar arquivos .drawio vazios
echo. > diagramas\fonte\diagrama_classes.drawio
echo. > diagramas\fonte\diagrama_casos_uso.drawio
echo. > diagramas\fonte\diagrama_sequencia_login.drawio
echo. > diagramas\fonte\diagrama_sequencia_agendamento.drawio
echo. > diagramas\fonte\diagrama_atividade.drawio
echo. > diagramas\fonte\diagrama_componentes.drawio
echo. > diagramas\fonte\diagrama_pacotes.drawio
echo. > diagramas\fonte\diagrama_objetos.drawio

:: Criar arquivo CHANGELOG.md
echo # Changelog dos Diagramas UML > diagramas\CHANGELOG.md
echo. >> diagramas\CHANGELOG.md
echo ## [1.0.0] - 2024-03-19 >> diagramas\CHANGELOG.md
echo. >> diagramas\CHANGELOG.md
echo ### Adicionado >> diagramas\CHANGELOG.md
echo - Estrutura inicial dos diagramas UML >> diagramas\CHANGELOG.md
echo - Diagrama de Classes >> diagramas\CHANGELOG.md
echo - Diagrama de Casos de Uso >> diagramas\CHANGELOG.md
echo - Diagrama de Sequência (Login) >> diagramas\CHANGELOG.md
echo - Diagrama de Sequência (Agendamento) >> diagramas\CHANGELOG.md
echo - Diagrama de Atividade >> diagramas\CHANGELOG.md
echo - Diagrama de Componentes >> diagramas\CHANGELOG.md
echo - Diagrama de Pacotes >> diagramas\CHANGELOG.md
echo - Diagrama de Objetos >> diagramas\CHANGELOG.md

echo.
echo Estrutura de diretórios criada com sucesso!
echo.
echo Para começar a criar os diagramas:
echo 1. Acesse https://app.diagrams.net/
echo 2. Abra os arquivos .drawio na pasta diagramas\fonte
echo 3. Crie os diagramas seguindo as especificações no README.md
echo 4. Exporte as imagens para a pasta diagramas\imagens
echo.
pause 