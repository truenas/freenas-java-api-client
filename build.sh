#!/bin/sh

mvn clean install
if [ $? -eq 0 ]; then
    cd freenas-cli
    java -jar target/freenas-*-with-*.jar -alerts list all
    cd ../
fi
