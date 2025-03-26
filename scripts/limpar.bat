@echo off
echo Limpando arquivos compilados...

REM Remover diretório bin se existir
if exist bin rmdir /s /q bin

REM Criar diretório bin novamente
mkdir bin

echo Limpeza concluída!
pause 