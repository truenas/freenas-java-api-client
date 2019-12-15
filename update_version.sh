#mvn versions:set -DnewVersion=1.1-SNAPSHOT
VERSION="1.1-SNAPSHOT"
mvn versions:set -DnewVersion=$VERSION
cd freenas-entities
cd ..
mvn versions:set -DnewVersion=$VERSION
cd freenas-client
cd ..
mvn versions:set -DnewVersion=$VERSION
cd freenas-cli
cd ..
mvn versions:set -DnewVersion=$VERSION


