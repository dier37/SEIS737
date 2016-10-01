#!/bin/bash

rm -rf output
hadoop jar WordCount.jar mystuff.WordCount -fs file:/// -jt local input output
cat out/part-r-00000
