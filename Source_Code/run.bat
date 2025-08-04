@echo off
title RedCell Blood Bank Management System

REM Store the current directory
set APP_DIR=%~dp0

REM Check Java installation
echo Checking Java installation...
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed!
    echo Please install Java 21 LTS from: https://adoptium.net/temurin/releases/?version=21
    echo Make sure to install Java 21 (LTS version)
    start https://adoptium.net/temurin/releases/?version=21
    pause
    exit /b 1
)

REM Check Java version
java -version 2>&1 | find "version" > temp.txt
set /p JAVA_VERSION=<temp.txt
del temp.txt
echo Found: %JAVA_VERSION%

REM Check Maven installation
echo Checking Maven installation...
mvn -version >nul 2>&1
if errorlevel 1 (
    echo Error: Maven is not installed!
    echo Please install Maven from: https://maven.apache.org/download.cgi
    start https://maven.apache.org/download.cgi
    pause
    exit /b 1
)

echo Found Maven: 
mvn -version | find "Apache Maven"

REM Clean and package the application
echo.
echo Building the application...
call mvn clean package -DskipTests

if errorlevel 1 (
    echo.
    echo Build failed! Please check the error messages above.
    pause
    exit /b 1
)

REM Run the application
echo.
echo Starting RedCell Blood Bank Management System...
call mvn javafx:run

if errorlevel 1 (
    echo.
    echo Application failed to start! Please check the error messages above.
    pause
    exit /b 1
)

pause 