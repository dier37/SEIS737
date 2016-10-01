#!/bin/bash

# Make sure you are in the directory where the java files are
# For this example, the files are in /home/training/WordCount directory, so we switch to there

cd /home/training/WordCount

# We compile all the java files there.

javac -d /home/training/WordCount -classpath `hadoop classpath` *.java

# This will create the class files in a directory called mystuff
# That is because in the first line of Java source files we have specified the package name as mystuff
# 
# We will then jar the class files in the mystuff directory and call the jar files whatever we want
# I called this file WordCount.jar for consistency
# the switches c means create, v means verbose, and f means create a jar file

jar -cvf WordCount.jar mystuff

# We can remove the class files now
# rm /home/training/WordCount/mystuff/*.class
