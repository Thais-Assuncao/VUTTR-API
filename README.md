 <h1 align="center"> VUTTR (Back-end) - Very Useful Tool to Remember </h1>
 
 
Este projeto é um desafio proposto pela  <a href="https://startaideia.com.br/">STARTAIDEIA</a>

<p> Esta aplicação é um repositório que faz o gerenciamento de ferramentas com seus respectivos nomes, links, descrições e tags. </p>

<h2>Requisitos utilizados para a execução da API</h2>
<ul>
    <li>
     Java 8           
    </li>
    <li>
    PostgreSQL (Utilizei o PgAdmin)
    </li>
</ul>
<h2> Tecnologias utilizadas </h2>
<ul>
    <li>
     Spring Boot Version 2.4.4
    </li>
    <li>
     Swagger
    </li>
    <li>
     OpenAPI
    </li>
     <li>
     Spring Data JPA
    </li>
     <li>
     Lombok
    </li>
      <li>
     Validation
    </li>
      <li>
     Spring Boot DevTools
    </li>
</ul>

<h2>Executando o Projeto</h2

Após clonar o projeto, seguir os seguintes passos:
 - Abra seu projeto em sua IDE preferida, no meu caso Eclipse.
 - Abra o banco de dados, eu utilizo o PostgreSQL juntamente com o PgAdmin, e crie um novo DB como nome de "desafio-startaideia"
 - Volte na IDE e abra o "application.properties" (src/main/resources) e altere colocando seu username e password do PgAdmin.
 - Agora você já pode rodar o seu projeto. Clique em cima do nome do projeto na lateral esquerda com o botão direito do mouse > Run Ass > Java Application.
Com isso seu projeto já deverá ter subido com sucesso e as tabelas terem sido criadas no seu Banco de Dados.

Agora temos duas opções para fazermos a insersão dos dados. Você pode copiar o script abaixo e rodar direto pelo PgAdmin.

```
insert into tools values (1, 'Notion', 'https://notion.so', 'All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized.')
insert into tools_tags values (1, 'organization')
insert into tools_tags values (1, 'planning')
insert into tools_tags values (1, 'organization')
insert into tools_tags values (1, 'writing')

insert into tools values (2, 'json-server', 'https://github.com/typicode/json-server', 'Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges.')
insert into tools_tags values (2, 'api')
insert into tools_tags values (2, 'json')
insert into tools_tags values (2, 'node')
insert into tools_tags values (2, 'github')
insert into tools_tags values (2, 'rest')

insert into tools values (3, 'fastify', 'https://www.fastify.io/', 'Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.')
insert into tools_tags values (3, 'web')
insert into tools_tags values (3, 'framework')
insert into tools_tags values (3, 'node')
insert into tools_tags values (3, 'http2')
insert into tools_tags values (3, 'https')
insert into tools_tags values (3, 'localhost')
```
Ou, ao invés disso você, pode tambem acessar o link <a href="http://localhost:3000/swagger-ui.html">http://localhost:3000/swagger-ui.html</a> e por ele já conseguir testar todas as suas requisões. Primeiro faço o método POST para cadastras as ferramentas para depois conseguir testar os outros métodos. Abaixo deixarei já no jeito para essa opção também. 

```
{
        "title": "Notion",
        "link": "https://notion.so",
        "description": "All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized. ",
        "tags": [
            "organization",
            "planning",
            "collaboration",
            "writing",
            "calendar"
        ]
    },
    {
        "title": "json-server",
        "link": "https://github.com/typicode/json-server",
        "description": "Fake REST API based on a json schema. Useful for mocking and creating APIs for front-end devs to consume in coding challenges.",
        "tags": [
            "api",
            "json",
            "schema",
            "node",
            "github",
            "rest"
        ]
    },
    {
       "title": "fastify",
        "link": "https://www.fastify.io/",
        "description": "Extremely fast and simple, low-overhead web framework for NodeJS. Supports HTTP2.",
        "tags": [
            "web",
            "framework",
            "node",
            "http2",
            "https",
            "localhost"
        ]
    }
```


