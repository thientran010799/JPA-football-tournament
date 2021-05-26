#!/bin/sh
mvn clean package && docker build -t com.axonactive.training.project/football_project_v3 .
docker rm -f football_project_v3 || true && docker run -d -p 8080:8080 -p 4848:4848 --name football_project_v3 com.axonactive.training.project/football_project_v3 
