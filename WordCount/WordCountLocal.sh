#!/bin/bash

rm -rf out
hadoop jar WordCount.jar mystuff.WordCount -fs file:/// -jt local in out
cat out/part-r-00000