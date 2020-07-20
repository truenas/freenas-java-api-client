#!/bin/sh

mvn clean install
cd freenas-cli
java -jar target/freenas-*-with-*.jar -alerts list all
cd ../
