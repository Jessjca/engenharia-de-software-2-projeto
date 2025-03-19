@echo off
echo Baixando drivers e dependências...
echo.

if not exist "lib" mkdir lib

echo Baixando SQLite JDBC...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.45.1.0/sqlite-jdbc-3.45.1.0.jar' -OutFile 'lib/sqlite-jdbc-3.45.1.0.jar' -UseBasicParsing } catch { Write-Host 'Erro ao baixar SQLite JDBC: ' $_.Exception.Message }"

echo Baixando SLF4J API...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.9/slf4j-api-2.0.9.jar' -OutFile 'lib/slf4j-api-2.0.9.jar' -UseBasicParsing } catch { Write-Host 'Erro ao baixar SLF4J API: ' $_.Exception.Message }"

echo Baixando SLF4J Simple...
powershell -Command "try { Invoke-WebRequest -Uri 'https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.9/slf4j-simple-2.0.9.jar' -OutFile 'lib/slf4j-simple-2.0.9.jar' -UseBasicParsing } catch { Write-Host 'Erro ao baixar SLF4J Simple: ' $_.Exception.Message }"

echo.
echo Verificando arquivos baixados...

if exist "lib\sqlite-jdbc-3.45.1.0.jar" (
    echo SQLite JDBC: OK
) else (
    echo ERRO: SQLite JDBC não foi baixado
)

if exist "lib\slf4j-api-2.0.9.jar" (
    echo SLF4J API: OK
) else (
    echo ERRO: SLF4J API não foi baixado
)

if exist "lib\slf4j-simple-2.0.9.jar" (
    echo SLF4J Simple: OK
) else (
    echo ERRO: SLF4J Simple não foi baixado
)

echo.
echo Se algum arquivo não foi baixado, por favor baixe manualmente:
echo 1. sqlite-jdbc-3.45.1.0.jar: https://github.com/xerial/sqlite-jdbc/releases
echo 2. slf4j-api-2.0.9.jar: https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.9/
echo 3. slf4j-simple-2.0.9.jar: https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.9/
echo.
echo Coloque todos os arquivos na pasta lib e execute o compilar.bat
pause 