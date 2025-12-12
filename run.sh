#!/bin/sh
java macros $1.java > test.java
if javac test.java; then
    rm -rf test.java
    echo "build successfull... "
else
    echo "fail"
fi

