@echo off
set GIT_PATH="C:\Program Files\Git\bin\git.exe"
set BRANCH = "origin gh-pages"

color cf
java -jar scraper.jar | tee scraper.log
color 2f

sleep 5
cls
echo committing to github...
sleep 1
%GIT_PATH% add -A
%GIT_PATH% commit -am "%date% %time% autoscrape JPG"
%GIT_PATH% pull %BRANCH%
%GIT_PATH% push %BRANCH%

pause
exit