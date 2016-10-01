#!/bin/bash

rm -rf output
hadoop jar MaxTemperature.jar MaxTemperature -fs file:/// -jt local input output
cat output/part-r-00000
