@echo off
echo Compilando o projeto...

REM Definir diretório base
set BASE_DIR=%~dp0..

REM Criar pasta bin
if not exist "%BASE_DIR%\bin" mkdir "%BASE_DIR%\bin"

REM Copiar imagem de fundo
if not exist "%BASE_DIR%\bin\resources" mkdir "%BASE_DIR%\bin\resources"
copy "%BASE_DIR%\src\main\resources\background.jpg" "%BASE_DIR%\bin\resources\"

REM Compilar
javac -cp "%BASE_DIR%\lib\*" "%BASE_DIR%\src\main\java\*.java" -d "%BASE_DIR%\bin"

REM Executar
java -cp "%BASE_DIR%\bin;%BASE_DIR%\lib\*" Main
pause 