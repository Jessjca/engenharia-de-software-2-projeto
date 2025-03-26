@echo off
echo Compilando e executando testes...

REM Definir diretório base
set BASE_DIR=%~dp0..

REM Criar diretório bin se não existir
if not exist "%BASE_DIR%\bin" mkdir "%BASE_DIR%\bin"

REM Definir classpath com caminhos absolutos
set CLASSPATH=%BASE_DIR%;%BASE_DIR%\bin;%BASE_DIR%\lib\junit-4.13.2.jar;%BASE_DIR%\lib\hamcrest-core-1.3.jar;%BASE_DIR%\lib\sqlite-jdbc-3.45.1.0.jar;%BASE_DIR%\lib\slf4j-api-2.0.9.jar;%BASE_DIR%\lib\slf4j-simple-2.0.9.jar

REM Compilar classes principais
echo Compilando classes principais...
javac -d "%BASE_DIR%\bin" "%BASE_DIR%\src\main\java\*.java"

REM Compilar testes
echo Compilando testes...
javac -cp "%CLASSPATH%" -d "%BASE_DIR%\bin" "%BASE_DIR%\src\test\java\*.java"

REM Executar testes com carregamento explícito do driver SQLite
echo Executando testes...
java -cp "%CLASSPATH%" -Djava.sql.drivers=org.sqlite.JDBC org.junit.runner.JUnitCore UsuarioTest AgendamentoTest DatabaseManagerTest

echo.
pause 