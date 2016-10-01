#!/bin/bash

hadoop fs -rm -r output
hadoop fs -rm -r input
hadoop fs -mkdir input
hadoop fs -put input/sample.txt input
hadoop jar MaxTemperature.jar MaxTemperature input output
hadoop fs -cat output/part-r-00000
