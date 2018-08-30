#! /bin/bash

set -e


. ./set-env-${DATABASE?}.sh

docker-compose -f docker-compose-${DATABASE?}.yml down -v

docker-compose -f docker-compose-${DATABASE?}.yml up -d --build zookeeper ${DATABASE?} kafka

./wait-for-${DATABASE?}.sh

docker-compose -f docker-compose-${DATABASE?}.yml up -d --build cdcservice

./wait-for-services.sh $DOCKER_HOST_IP "8099"

./gradlew assemble

docker-compose -f docker-compose-${DATABASE?}.yml up -d --build 

./wait-for-services.sh $DOCKER_HOST_IP "8081 8082"


