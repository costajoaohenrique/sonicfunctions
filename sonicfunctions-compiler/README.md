# The Sonic Functions Project


- Example request get

http://localhost:8080/api/eval?source=olaMundoJs('Ola Mundo Js');function olaMundoJs(valor) {console.log(valor); return valor;}


https://quarkus.io/guides/hibernate-orm-panache-guide


https://medium.com/@renato.groffe/postgresql-docker-executando-uma-inst%C3%A2ncia-e-o-pgadmin-4-a-partir-de-containers-ad783e85b1a4

- Criando Banco de Dados Postgres com Docker

docker network create --driver bridge postgres-network

docker run --name sf-postgres --network=sf-network -e "POSTGRES_PASSWORD=sonicfunctions" -p 5432:5432 -v /home/sf/Desenvolvimento/PostgreSQL:/var/lib/postgresql/data -d postgres

docker run --name sf-pgadmin --network=sf-network -p 15432:80 -e "PGADMIN_DEFAULT_EMAIL=sonicfunctions@gmail.com.br" -e "PGADMIN_DEFAULT_PASSWORD=sonicfunctions" -d dpage/pgadmin4



- Casos de Uso:

- Receber uma funcao via rest, compilar e verificar se esta valido OK
- Poder executar funcao
- Poder executar funcao junto com código ja na base (mockado)



