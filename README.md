# cashback-vinil

### Informações importantes:

- É necessário ter Maven, Docker e Docker Compose instalados na máquina que executará os serviços.
- O banco é criado quando os containers inicializam, não foi usando nenhum 'volume' para manter os dados do banco ápos o container finalizar.
- A 'carga básica' do banco é executada pelo serviço de vendas. Os discos são inseridos por carga também, pois não consegui chegar na parte de utilizar o serviço do Spotify para carregar os albúns diretamente.
- O banco 'app' pode ser acessado pela porta padrão do MySQL (3306), que está exposta pelo container. Os outros serviços de apoio também estão expostos em portas, vide o arquivo docker-compose.yml na raiz.
- Os testes dos 'endpoints' foram realizados com o Postman.
- Existem alguns pontos que poderiam ser melhores, e até mais um serviço poderia existir para servir como 'gateway' do serviço principal de vendas, mas não tive tempo de montá-lo.

### Para utilizar a aplicação:

- Baixe o código-fonte;
- Entre na raiz do repositório (/cashback-vinil);
- Abra o prompt de comando (ou terminal, se estiver no Linux/Mac OS) nessa pasta;
- Primeiro, é necessário gerar os artefatos usando o Maven: 
```
mvn clean package
```
- Os testes unitários serão executados. Caso queira rodar somente os testes:
```
mvn test
```
- Com o código compilado e os artefatos construídos, é necessário construir as imagens do Docker:
```
docker-compose build
```
- Depois é só subir os containers com as imagens criadas:
```
docker-compose up
```

### Endpoints:

A aplicação usa REST e os endpoints são:

##Discos:
- GET por Identificador - http://localhost:8080/venda-service/disco/{id}
- GET paginado com filtro de genero - http://localhost:8080/venda-service/disco?page=0&limit=10&generoId=1

##Vendas:
- POST para cadastro - http://localhost:8080/venda-service/venda
	- O corpo da request deve ter os identificadores dos discos em formato JSON:
```
{"discos": [{"id": 1}, {"id":2}]}
```
- GET por Identificador - http://localhost:8080/venda-service/venda/{id}
- GET paginado com filtro de datas - http://localhost:8080/venda-service/venda?limit=10&page=0&inicio=2019-01-01T12:00:00.000&fim=2019-01-30T12:00:00.000

### Qualquer dúvida, estou a disposição.