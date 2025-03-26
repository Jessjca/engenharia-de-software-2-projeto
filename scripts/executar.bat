@echo off
echo Compilando o programa...
cd ..
javac -d bin src/main/java/model/*.java src/main/java/controller/*.java src/main/java/view/*.java
if errorlevel 1 (
    echo Erro na compilacao!
    pause
    exit
)
echo Executando o programa...
java -cp "bin;lib/*" view.MainView
pause 