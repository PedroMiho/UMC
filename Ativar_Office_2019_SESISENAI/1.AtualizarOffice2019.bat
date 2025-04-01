@echo off
REM Desativa a exibição dos comandos sendo executados

chcp 65001
REM Define o código de página do console para UTF-8

cd "\Program Files\Common Files\microsoft shared\ClickToRun"
REM Navega para o diretório onde o executável OfficeC2rclient.exe está localizado

OfficeC2rclient.exe /update user updatetoversion=16.0.13801.20266
REM Executa o OfficeC2rclient.exe com o comando para atualizar para a versão 16.0.13801.20266 do Microsoft Office

exit
REM Encerra a execução do script .bat
