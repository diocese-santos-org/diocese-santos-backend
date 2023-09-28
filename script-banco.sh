#!/bin/bash

DOCKER_COMPOSE_FILE=docker-compose-banco.yml

#Entrando na pasta banco-local
cd banco-local

#Validação: de o Docker esta em execução
if ! docker info > /dev/null 2>&1; then
  echo "O Docker não está em execução"
  exit 1
#Docker está em execução
else
  if docker container inspect mysql_diocese > /dev/null 2>&1; then
    echo "O container está em execução"
  else
    docker-compose -f $DOCKER_COMPOSE_FILE up -d
    echo "Container sendo criado/executado"

    echo "Aguardando 20s..."
    sleep 30
    echo "Executado com sucesso!"

  fi
fi