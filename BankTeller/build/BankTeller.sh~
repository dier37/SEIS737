#!/bin/bash

hadoop fs -rm -r out
hadoop fs -rm -r in
hadoop fs -mkdir in
hadoop fs -put in/*.txt in
hadoop jar WordCount.jar mystuff.WordCount in out
hadoop fs -cat out/part-r-00000