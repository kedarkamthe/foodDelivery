#! /bin/bash
# setup Agent

curl --location 'http://localhost:8080/foodDelivery/agents' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Bob"
}'

curl --location 'http://localhost:8080/foodDelivery/agents' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Alice"
}'

curl --location 'http://localhost:8080/foodDelivery/agents' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Matt"
}'