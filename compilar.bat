@echo off
echo Criando pasta bin...
if not exist "bin" mkdir bin
echo.
echo Compilando o projeto...
javac -cp "lib/*" src/main/java/*.java -d bin
echo.
echo Executando o programa...
java -cp "bin;lib/*" Main
pause 