@echo off
echo Compilando as classes principais...
cd ..
javac -cp "lib/*" -d bin src/main/java/model/*.java src/main/java/controller/*.java src/main/java/view/*.java
if errorlevel 1 (
    echo Erro na compilacao das classes principais!
    pause
    exit /b 1
)

echo Compilando os testes...
javac -cp "bin;lib/*" -d bin src/test/java/model/*.java src/test/java/controller/*.java src/test/java/view/*.java
if errorlevel 1 (
    echo Erro na compilacao dos testes!
    pause
    exit /b 1
)

echo Executando os testes...
java -cp "bin;lib/*" org.junit.runner.JUnitCore model.UsuarioTest model.AgendamentoTest model.DatabaseManagerTest controller.MainControllerTest view.MainViewTest
pause 