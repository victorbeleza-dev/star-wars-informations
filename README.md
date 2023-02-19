# star-wars-informations

## Instruções para usar ambas as partes
* 1 - Clone o repositório;
* 2 - Entre na primeira pasta;
* 3 - Abra o bash, e digite mvn clean install para instalar as dependencias do projeto;
* 4 - Digite mvn spring-boot:run para rodar o programa;
* 5 - Repita o mesmo procedimento para a segunda pasta;

**Se ultilizar o intelij basta abrir a pasta nele esperar baixar as dependecias e clicar no botão abaixo:**
![image](https://user-images.githubusercontent.com/51977789/219923153-fd0f3ead-6a3e-488f-bc1b-ca3c2f5075f0.png)


## Primeira parte (pasta starwars)

## Proposta
* Faça uma API REST simples que retorne uma listagem de Filmes The Star Wars utilizando a API do https://swapi.dev/ que tenha como personagem envolvido Luke Skywalker;
* Criar um filtro para busca por title e episode_id;
* O retorno do campo “release_date” ser no formato dd/MM/yyyy;

## Funcionalidades 
* Listar todos os filmes de star wars em que o personagem Luke Skywalker esteja atuando;
* Listar filmes de star wars por episode_id e title;

## Pré-requisitos
* Java (openjdk 17)
* Intellij Community / Eclipse
* Maven

## Rotas para consultas
* A consulta de todos os filmes é feita através de um request que pode ser feita pela rota **localhost:8080/informations/movies** do tipo **GET** e deve retornar o response abaixo;
```
[
    {
        "title": "A New Hope",
        "episode_id": "4",
        "director": "George Lucas",
        "release_date": "25/05/1977"
    },
    {
        "title": "The Empire Strikes Back",
        "episode_id": "5",
        "director": "Irvin Kershner",
        "release_date": "17/05/1980"
    },
    {
        "title": "Return of the Jedi",
        "episode_id": "6",
        "director": "Richard Marquand",
        "release_date": "25/05/1983"
    },
    {
        "title": "Revenge of the Sith",
        "episode_id": "3",
        "director": "George Lucas",
        "release_date": "19/05/2005"
    }
]
```

* A segunda consulta é reponsavel pelo filtro e se econtra na rota **localhost:8080/informations/movie** com os path parameters **idEp**(id do episódio) e **titleEp**(titulo do episódio) (exemplo: **localhost:8080/informations/movie?idEp=5&titleEp=The Empire Strikes Back**) desse modo irá retornar a consulta de um filme especifico, como no response abaixo;
```
[
    {
        "title": "The Empire Strikes Back",
        "episode_id": "5",
        "director": "Irvin Kershner",
        "release_date": "17/05/1980"
    }
]
```

## Segunda parte (pasta directors)

## Proposta
* Agora você se tornou o diretor da Saga e vai lançar um novo filme com a participação do Luke Skywalker. Então desenvolva uma aplicação que utilize a API desenvolvida no Desafio 1 como fonte dos dados, e insira mais um item na listagem de filmes de sua imaginação;
* Escrever a nova listagem de filmes no console da aplicação;
* Salvar a nova listagem de filmes em um banco de dados H2 Database;
* Implementação de testes unitários;

## Funcionalidades 
* Inserir um novo filme na lista que é buscada na parte 1 do projeto;
* Escrever a nova listagem de filmes no console da aplicação;
* Salvar a nova listagem de filmes em um banco de dados H2 Database;

## Pré-requisitos
* Java (openjdk 17)
* Intellij Community / Eclipse
* Maven

## Rotas para consultas
* A rota para inserir um novo filme na lista é **localhost:8081/director/movie** como post e precisa de um body json como do exemplo abaixo:
```
{
    "title": "Novo Filme SW",
    "episode_id":"7",
    "director":"VICTORBELEZA",
    "release_date":"30/12/1998"
}
```
* Após o request ele irá buscar a lista de filmes ja existentes na primeira parte e irá inserir o filme novo na lista, aparecendo no console todos os filmes dessa lista como no exemplo abaixo (Pode demorar um pouco pois a api consumida é de terceiros):
**![image](https://user-images.githubusercontent.com/51977789/219922750-db6338d1-a6a5-48d1-8d2a-c6b13fe7bcd3.png)**
* Após isso irá ser inserida no Banco de dados H2 na rota **localhost:8081/h2-console** pode se logar com os dados abaixo:
```
JDBC URL: jdbc:h2:mem:dcbapp
User Name: sa
Password: password
```
* Por ultimo irá retornar um json com a Lista atualizada como no exemplo abaixo;
```
[
    {
        "title": "A New Hope",
        "episode_id": "4",
        "director": "George Lucas",
        "release_date": "25/05/1977"
    },
    {
        "title": "The Empire Strikes Back",
        "episode_id": "5",
        "director": "Irvin Kershner",
        "release_date": "17/05/1980"
    },
    {
        "title": "Return of the Jedi",
        "episode_id": "6",
        "director": "Richard Marquand",
        "release_date": "25/05/1983"
    },
    {
        "title": "Revenge of the Sith",
        "episode_id": "3",
        "director": "George Lucas",
        "release_date": "19/05/2005"
    },
    {
        "title": "Novo Filme SW",
        "episode_id": "7",
        "director": "VICTORBELEZA",
        "release_date": "30/12/1998"
    }
]
```
## Considerações
* Os testes unitários foram implementados usando Junit;
* Para comunicação dos microserviços foi ultilizado o FeingClient;
* Os mappers foram feitos ultilizando o ModelMapper para facilitar o desenvolvimento;
* A formatação da data foi feita ultilizando o LoacalDate;
* O primeiro serviço sobe na porta **8080** e o segundo na **8081**;
* O banco de dados H2 é ultilizado tanto nos testes quanto na api;
