#!/bin/bash
set -e

echo "DB_URL=$DB_URL" > .env
echo "DB_USERNAME=$DB_USERNAME" > .env
echo "DB_PASSWORD=$DB_PASSWORD" > .env

java -jar app.jar
