@echo off
echo Baixando dependencias necessarias...

REM Definir diretório base
set BASE_DIR=%~dp0..

REM Criar pasta lib se não existir
if not exist "%BASE_DIR%\lib" mkdir "%BASE_DIR%\lib"

REM Baixar SQLite JDBC
echo Baixando SQLite JDBC...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.45.1.0/sqlite-jdbc-3.45.1.0.jar' -OutFile '%BASE_DIR%\lib\sqlite-jdbc-3.45.1.0.jar' } catch { Write-Host 'Erro ao baixar SQLite JDBC' }"

REM Baixar SLF4J
echo Baixando SLF4J...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.9/slf4j-api-2.0.9.jar' -OutFile '%BASE_DIR%\lib\slf4j-api-2.0.9.jar' } catch { Write-Host 'Erro ao baixar SLF4J API' }"
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.9/slf4j-simple-2.0.9.jar' -OutFile '%BASE_DIR%\lib\slf4j-simple-2.0.9.jar' } catch { Write-Host 'Erro ao baixar SLF4J Simple' }"

echo.
echo Download concluido!
pause 