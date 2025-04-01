@echo off
REM Desativa a exibição dos comandos sendo executados

chcp 65001
REM Define o código de página do console para UTF-8

cd /d "%ProgramFiles(x86)%\Microsoft Office\Office16"
REM Navega para o diretório do Microsoft Office, assumindo que está instalado em "%ProgramFiles(x86)%\Microsoft Office\Office16". O parâmetro /d é usado para alterar para o diretório especificado em uma unidade diferente, se necessário.

for /f %%x in ('dir /b ..\root\Licenses16\ProPlus2019VL*.xrm-ms') do (
    REM Loop que itera sobre os arquivos .xrm-ms no diretório "..\root\Licenses16\ProPlus2019VL"
    cscript ospp.vbs /inslic:"..\root\Licenses16\%%x"
    REM Instala a licença especificada por cada arquivo .xrm-ms encontrado
)

cscript ospp.vbs /setprt:1688
REM Configura o servidor de ativação para o KMS (Key Management Service) na porta 1688

cscript ospp.vbs /unpkey:6MWKP >nul
REM Remove a chave de produto (product key) especificada (no exemplo, "6MWKP"). O ">nul" redireciona a saída para nul, suprimindo qualquer mensagem de retorno.

cscript ospp.vbs /inpkey:BR9TJ-6NR29-3HWW9-24JWY-TXY9Q
REM Insere a chave de produto (product key) especificada (no exemplo, "BR9TJ-6NR29-3HWW9-24JWY-TXY9Q")

cscript ospp.vbs /sethst:e8.us.to
REM Define o host do serviço de ativação (activation host) para "e8.us.to"

cscript ospp.vbs /act
REM Ativa o Microsoft Office utilizando as configurações especificadas

pause
REM Pausa a execução do script, exibindo a mensagem "Pressione qualquer tecla para continuar...", permitindo que o usuário veja o resultado antes de fechar o console
