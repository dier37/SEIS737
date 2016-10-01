#!/bin/bash

javac -classpath `hadoop classpath` *.java
jar cvf MaxTemperature.jar *.class
rm *.class
