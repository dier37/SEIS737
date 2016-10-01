#!/bin/bash

hadoop fs -rm -r output
hadoop fs -rm -r input
hadoop fs -mkdir input
hadoop fs -put in/*.txt input
hadoop jar BankTeller.jar mystuff.BankTeller input output
hadoop fs -cat out/part-r-00000
