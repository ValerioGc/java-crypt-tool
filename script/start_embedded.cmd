@echo off
set JVM_PATH=%~dp0jre\bin\java.exe
set JAR_PATH=%~dp0tuo-progetto.jar

if not exist "%JVM_PATH%" (
    echo Creazione errore...
    cscript //nologo "%~dp0error.vbs" "Errore: JVM non trovata. Verifica che la cartella 'jre' sia accanto al file."
    exit /b
)

if not exist "%JAR_PATH%" (
    echo Creazione errore...
    cscript //nologo "%~dp0error.vbs" "Errore: File JAR non trovato. Verifica che 'tuo-progetto.jar' sia presente."
    exit /b
)

start "" "%JVM_PATH%" -jar "%JAR_PATH%"
