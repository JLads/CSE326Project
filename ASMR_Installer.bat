::  @author Steven Anaya
::
:: Compile ASMR on Windows and create an executable JAR file

@echo off
setlocal EnableDelayedExpansion

:: Set cmd window name
title ASMR Installer

:: Work dirs
set "SRCDIR=%~dp0\src"
set "BUILDDIR=%~dp0\build"

:: Componenets
set "MAIN=ASMR"
set "BUILDPATH=%BUILDDIR%\%MAIN%"
set "CLASSPATH=%SRCDIR%\%MAIN%"
set "MAINCLASS=%BUILDPATH%\%MAIN%.class"
set "MAINJAVA=%CLASSPATH%\%MAIN%.java"
set "MAINJAR=%~dp0\%MAIN%.jar"

:: Get path of JDK
set "JROOT=C:\Program Files\Java"
for /f "delims=" %%a in ('dir /b "%JROOT%\jdk*"') do set "JPATH=%JROOT%\%%a"

:: Compile commands
set "JC=%JPATH%\bin\javac"
set "JFLAGS=-d ^"%BUILDDIR%^" -classpath ^"%CLASSPATH%^""

:: Jar commands
set "JAR=%JPATH%\bin\jar"
set "JARFLAGS=cfe ^"%MAINJAR%^" %MAIN%.%MAIN%"

:: Main execution

:: Delete old ASMR.jar
if exist %MAINJAR% del %MAINJAR%

:: Acquire all the source files
cd %SRCDIR%
for /r %%a in (*.java) do set "SRCS=!SRCS! ^"%%a^""
cd ..

:: Compile .class files
if not exist %BUILDDIR%\ mkdir "%BUILDDIR%"
"%JC%" %JFLAGS% %SRCS%

:: Make JAR file, clean up
"%JAR%" %JARFLAGS% -C "%BUILDDIR%" %MAIN%
@RMDIR /s /q %BUILDDIR%

if exist %MAINJAR% echo ASMR.jar has been successfully created^^!
pause
