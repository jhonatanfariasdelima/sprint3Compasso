# sprint3Compasso

Banco de dados: mariaDB - porta 3307
Testes no postman - http://localhost:8080/api/cars - (GET/POST)

GET:
  Aplicação de filtros por parametros da url: 

  a. Filtrar carros por marca - http://localhost:8080/api/cars?marca=tesla

  b. Filtrar carros por modelo - http://localhost:8080/api/cars?modelo=modelX

  c. Filtrar carros por cor - http://localhost:8080/api/cars?cor=prata

  d. Filtrar o carro mais caro - http://localhost:8080/api/cars?size=1&sort=valor,desc

  e. Filtrar o carro mais barato - http://localhost:8080/api/cars?size=1&sort=valor,asc

  f. Ordenar por modelo - http://localhost:8080/api/cars/?sort=modelo,desc/asc

  g. Ordenar valor - http://localhost:8080/api/cars/?sort=valor,desc/asc

  h. Ordenar por ano de fabricação - http://localhost:8080/api/cars/?sort=anoFabricacao,desc/asc

  i. mistura de filtros - http://localhost:8080/api/cars?modelo=modelX&cor=prata&sort=valor,desc

POST:
  Content-Type: application/json
  {
    "chassi": "258963254789653265",
    "modelo": "cruze",
    "marca": "asd",
    "cor": "azul",
    "valor": 100.00,
    "anoFabricacao": 2011
  }

DELETE:
  http://localhost:8080/api/cars?chassi=115ASD215SDF478SDF
