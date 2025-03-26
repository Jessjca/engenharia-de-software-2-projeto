@echo off
echo Verificando dependencias...

REM Definir diretório base
set BASE_DIR=%~dp0..

REM Verificar pasta lib
if not exist "%BASE_DIR%\lib" (
    echo Erro: Pasta lib nao encontrada!
    echo Execute os scripts de download primeiro.
    pause
    exit /b 1
)

REM Verificar arquivos
set FALTA=0

if not exist "%BASE_DIR%\lib\junit-4.13.2.jar" (
    echo Falta: junit-4.13.2.jar
    set FALTA=1
)

if not exist "%BASE_DIR%\lib\hamcrest-core-1.3.jar" (
    echo Falta: hamcrest-core-1.3.jar
    set FALTA=1
)

if not exist "%BASE_DIR%\lib\sqlite-jdbc-3.45.1.0.jar" (
    echo Falta: sqlite-jdbc-3.45.1.0.jar
    set FALTA=1
)

if not exist "%BASE_DIR%\lib\slf4j-api-2.0.9.jar" (
    echo Falta: slf4j-api-2.0.9.jar
    set FALTA=1
)

if not exist "%BASE_DIR%\lib\slf4j-simple-2.0.9.jar" (
    echo Falta: slf4j-simple-2.0.9.jar
    set FALTA=1
)

if %FALTA%==1 (
    echo.
    echo Execute os seguintes scripts:
    echo 1. baixar_driver.bat
    echo 2. baixar_junit4.bat
    pause
    exit /b 1
)

echo Todas as dependencias estao presentes!
pause 