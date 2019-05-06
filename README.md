# Analysis of Serial Memory and Recognition (ASMR)
## Purpose
This software was made for our Software Engineering course (CSE 326) at New Mexico Tech in Socorro, New Mexico, USA at the request of and with guidance from our customer, Dr. Taffetta Elliot with the Psychology department at the same institution.

This software is an application to facilitate the testing of subjects' abilities to hear and recall auditory sequences and to analyze the subjects' test results using R. This software is portable to both Windows and Linux.

Three primary services are provided by this software:
* Create arbitrary-length tests containing pairs of audio test sequences of length five
* Initiate a testing session and record the subject's responses
* Perform a basic analysis of a subject's test results including a performance summary and a plot of subject performance over the length of the test

## Installation Instructions
The software package comes with a pre-compiled `ASMR.jar` file in the package root directory, but you may re-compile if you wish to make changes by performing the following steps on Windows or Linux.

### On Windows
Execute the `ASMR_Installer.bat` file inside the package root directory by clicking on it.

### On Linux
Run the command `make` from the terminal while inside the package root directory. If `ASMR.jar` already exists, run the command `make clean` first.

## Application Usage

### On Windows
Simply click on the `ASMR.jar` file in the package root directory. Alternatively, you can also make a shortcut to the JAR file anywhere on your system and click on the shortcut instead.

### On Linux
Run the command `java -jar ASMR.jar` from the terminal while inside the package root directory or set `java -jar` as the default command to use on the file when you click on it in a file manager. You can also create a symbolic link to the `.jar` file anywhere on your desktop using the command `ln -s` from the terminal.

### Test Creation
Test creation is initiated by clicking the "Create Test File" button in the main menu. From there, a new screen will appear that contains several file selection fields. You will be asked to select a directory containing the audio files you wish to include in the testing set.

After selecting this directory, you may select five of these files for each test sequence. The sequences may contain repitions, but must contain *exactly* five audio files. Under the sequence selection fields, there is a checkbox that is used to indicate whether or not the sequences are identical.

After filling in each sequence, you may then click "Add Test" to add the sequence pair to the testing set. You may add as many tests as you like. When done, click "Save Test File" and select a directory path and file name to save the testing configuration to the hard drive as a CSV file.

### Subject Testing
Subject testing is initiated by clicking the "Run Test" button in the main menu. You will then be prompted to select a test file consistent with the CSV format specified below. These files may be created by hand or by using the GUI as explained above.

A new screen will then appear that contains test instructions for the test subject and a button to start the test when ready. At that point, a screen will appear containing a "Play Audio" button. When clicked, the two sequences will play consecutively, separated by two seconds of silence. The sequences cannot be replayed. At that point, the subject must click either "Yes" to indicate the sequences were identical or "No" to indicate that they were not.

A test score is shown on the screen which may change value based on correct or incorrect answers by values that you may change in the `responseType` enumeration in `src/ASMR/Data/TestLogger.java`. If you change this file, the software must be re-compiled as explained above in order to use the new values.

After the test is over, a screen will appear informing the subject to return to the administrator (you). Once the "Continue" button is clicked, you may then select a directory path and file name to save the test results to the hard drive as a CSV file.

### Test Results Analysis
Results Analysis is initiated by clicking the "Analyze Results File" button in the main menu. You will then be prompted to select a results file from the file system for analysis and then to select a directory path and file name to save the analysis results.

**Analysis in this application requires a proper R installation with a working `RScript` executable in `/usr/bin` on Linux or an `RScript.exe` executable in the location of your R installation on Windows. On Windows, R must have been installed from the official R Project website to work with this application properly**.

Two files will then be generated in the directory chosen: the analysis results file containing a summary of the analysis results in the format explained below and a plot showing how the test subject's score increased or decreased as correct or incorrect results were given.

## File Format
The following types of files usable or created by ASMR conform to the following formats.
### Test Configuration File
If you wish to make a custom test configuration CSV outside of the GUI, it *must* conform to the following format to work properly with ASMR.
```
/path/to/sound/file/directory ASMR
audio,files,in,test1,sequence1,separated,by,commas
audio,files,in,test1,sequence,2,separated,by,commas
'yes' if sequences are the same else 'no'

/path/to/sound/file/directory ASMR
audio,files,in,test2,sequence1,separated,by,commas
audio,files,in,test2,sequence2,separated,by,commas
'yes' if sequences are the same else 'no'

...

/path/to/sound/file/directory ASMR
audio,files,in,testN,sequence1,separated,by,commas
audio,files,in,testN,sequence2,separated,by,commas
'yes' if sequences are the same else 'no'

```
Example:
```
/home/timapple/Documents/ASMR/wav_files/42instrumentEflat ASMR
01_ASaxEb5_2.53s_short_A.wav,02_AfltEb4_2.41sec_altoNoVib_mono_short_A.wav,03_AltoShawm_Eb4_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav,05_BachTptEb4_4.10sec_mono_short_A.wav
05_BachTptEb4_4.10sec_mono_short_A.wav,02_AfltEb4_2.41sec_altoNoVib_mono_short_A.wav,03_AltoShawm_Eb4_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav,05_BachTptEb4_4.10sec_mono_short_A.wav
no

/home/timapple/Documents/wav_files/42instrumentEflat ASMR
01_ASaxEb5_2.53s_short_A.wav,02_AfltEb4_2.41sec_altoNoVib_mono_short_A.wav,03_AltoShawm_Eb4_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav
01_ASaxEb5_2.53s_short_A.wav,02_AfltEb4_2.41sec_altoNoVib_mono_short_A.wav,03_AltoShawm_Eb4_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav,04_BFltEb4_4.05sec_vibrato_mono_short_A.wav
yes

```

### Test Results File
```
/path/to/test/configuration/file
Test#,Correct,Subject,Points
1,'yes' if same else 'no',subject answer ('yes' or 'no'),current test score (an integer)
2,'yes' if same else 'no',subject answer ('yes' or 'no'),current test score (an integer)
...
N,'yes' if same else 'no',subject answer ('yes' or 'no'),current testscore (an integer)
```
Example:
```
/home/rms/Documents/test.csv
Test#,Correct,Subject,Points
1,no,no,10
2,yes,no,5
```

### Analysis Results File
```
Test file: /path/to/test/configuration/file
Data file: /path/to/test/results/file
Number of test: an integer
Subject Final Score: an integer
Proportion Answers Correct: a real number
```
Example:
```
Test file: /home/sdlavrot/Documents/test.csv
Data File: /home/sdlavrot/Documents/result.csv
Number of tests: 2
Subject Final Score: 5
Proportion Answers Correct: 0.5
```
