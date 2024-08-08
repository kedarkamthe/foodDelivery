#! /bin/bash
# setup food

curl --location 'localhost:8080/foodDelivery/foods' \
--header 'Content-Type: application/json' \
--data '{
    "isReserved": "false",
    "name": "Fries"
}'

curl --location 'localhost:8080/foodDelivery/foods' \
--header 'Content-Type: application/json' \
--data '{
    "isReserved": "false",
    "name": "Burger"
}'


curl --location 'localhost:8080/foodDelivery/foods' \
--header 'Content-Type: application/json' \
--data '{
    "isReserved": "false",
    "name": "Pizza"
}'