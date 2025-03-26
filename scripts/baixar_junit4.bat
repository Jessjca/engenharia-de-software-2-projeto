@echo off
echo Baixando JUnit 4...

REM Definir diretório base
set BASE_DIR=%~dp0..

REM Criar pasta lib se não existir
if not exist "%BASE_DIR%\lib" mkdir "%BASE_DIR%\lib"

REM Baixar JUnit e Hamcrest
echo Baixando JUnit e Hamcrest...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/junit/junit/4.13.2/junit-4.13.2.jar' -OutFile '%BASE_DIR%\lib\junit-4.13.2.jar' } catch { Write-Host 'Erro ao baixar JUnit' }"
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar' -OutFile '%BASE_DIR%\lib\hamcrest-core-1.3.jar' } catch { Write-Host 'Erro ao baixar Hamcrest' }"

echo.
echo Download concluido!
pause 