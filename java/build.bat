@cho off
title Build


@rem Lists all java files
dir "src\main\*.java" /s /b >files.txt
@echo on


@rem compile
"%JAVA_HOME%\bin\javac.exe" -encoding utf8 @files.txt -d target\classes
@echo off
echo "Jeśli kompilacja przebiegła pomyślnie, kliknij dowolny klawisz"
pause >nul
cls


cd classes
echo Aby uruchomic kliknij dowonly klawisz. Aby anulowac kliknij Ctrl+C lub zamknij program
pause >nul
cls


@echo on
java pl.codesharks.matura.Main
@echo off
pause