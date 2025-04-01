@echo off
echo Documentacao tecnica
echo Link: https://answers.uchicago.edu/page.php?id=28381
echo Link: https://social.technet.microsoft.com/wiki/pt-br/contents/articles/13615.ativando-o-windows-8-via-linha-de-comando.aspx
echo
echo Script de Ativacao das solucoes Microsoft
echo
echo Ativando o Microsoft Office 2019
echo
echo Instalando a licenca do Office 2019
slmgr /ipk BR9TJ-6NR29-3HWW9-24JWY-TXY9Q
echo
echo Ativando o Microsoft Office 2019
slmgr /ato
echo
echo Status da Ativacao
slmgr /dlv
pause
echo
exit