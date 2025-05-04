#!/bin/bash
set -e

if [ ! -f .env ]; then
  echo "Creating .env file..."
  echo "DB_URL=$DB_URL" > .env
  echo "DB_USERNAME=$DB_USERNAME" >> .env
  echo "DB_PASSWORD=$DB_PASSWORD" >> .env
else
  echo ".env already exists. Skipping creation."
fi

java -jar app.jar
