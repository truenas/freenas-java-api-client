#!/bin/sh

mvn clean install
cd freenas-cli
java -jar target/freenas-cli-1.1-SNAPSHOT-with-dependencies.jar -alerts list all
cd ../
