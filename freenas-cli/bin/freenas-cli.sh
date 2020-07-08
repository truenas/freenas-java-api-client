#!/bin/bash
# Run the java process and pass arguments
VERSION="1.1-SNAPSHOT"
PATH="../freenas-cli/target/freenas-cli-$VERSION-jar-with-dependencies.jar"
/usr/bin/java -jar $PATH "$@"
