
# BigQuery with Rest Api

This application has the purpose of performing raw operations using bigQuery as a data source.

The application consists of 4 endpoints that perform: Creation, Search for all items, Search for specific item and Deletion for specific item.





## Running locally

You will need to have a project configured in BigQuery with a data set and a Category table

I also point out that for it to work you need to have a billing account configured on Google Cloud.

To connect the app to BigQuery, you must configure your credentials in the Google Cloud console. When the creation is complete, you can download your credentials and fill them in the file "src/main/resources/credentials-bq.json"

With this, just run the application and test the corresponding methods


## Stack utilizada

**Back-end:** Kotlin, Spring, BigQuery


## App documentation

#### Create a new category
```http
  Post /category
```
Body:
```
{
	"id": Int,
	"name": String
}
```

#### Returns all category items

```http
  GET /category
```
#### Returns an item

```http
  GET /category/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. |

#### Delete an item

```http
  DELETE /category/${id}
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `int` | **Obrigatório**. |



## Useful queries

`````
SELECT * FROM `your-project.Vendas.Clientes` LIMIT 1000 
`````
`````
SELECT * FROM `your-project.Vendas.Clientes` WHERE first_name = "Mariana" LIMIT 1000 
`````
`````
SELECT DISTINCT first_name FROM `your-project.Vendas.Clientes`
`````
`````
SELECT first_name AS nome, last_name AS sobrenome FROM `your-project.Vendas.Clientes`
`````
`````
SELECT clientes.first_name AS nome, clientes.last_name AS sobrenome FROM `your-project.Vendas.Clientes` as clientes
`````
`````
SELECT first_name, last_name, state FROM `your-project.Vendas.Clientes` WHERE first_name in ("Marta", "Mariana")
`````
`````
SELECT first_name, last_name, state FROM `your-project.Vendas.Clientes` WHERE first_name in ("Marta", "Mariana") and state not in ("null")
`````
`````
SELECT * FROM `your-project.Vendas.Clientes` WHERE email is null
`````
`````
SELECT * FROM `your-project.Vendas.Itens` WHERE quantity = 2 AND total_price BETWEEN 200 AND 400 
`````
`````
SELECT * FROM `your-project.Vendas.Itens` WHERE quantity = 2
`````
`````
SELECT * FROM `your-project.Vendas.Itens` WHERE quantity <= 4
`````
`````
SELECT * FROM `your-project.Vendas.Itens` WHERE quantity < 4
`````
`````
SELECT * FROM `your-project.Vendas.Itens` WHERE quantity > 4
`````
`````
SELECT * FROM `your-project.Vendas.Clientes` WHERE email is not null
`````
`````
SELECT
id,
name,
CASE
  WHEN name in('Moda e Acessórios', 'Cosméticos e Perfumaria') then 'Bem estar'
  WHEN name in('Celulares', 'Informática', 'Eletrônicos', 'Eletrodomésticos') then 'Tecnologia'
  ELSE 'Outros'
  END AS categoria
FROM `your-project.Vendas.Categoria`
`````
`````
SELECT
DISTINCT
state,
CASE
  WHEN state in ('Paraná', 'Santa Catarina', 'Rio Grande do Sul') THEN 'Sul'
  WHEN state in ('São Paulo', 'Minas Gerais', 'Rio de Janeiro', 'Espírito Santo') THEN 'Sudeste'
  ELSE 'Outros'
  END AS regiao
FROM `your-project.Vendas.Clientes`
WHERE state IS NOT NULL
`````
`````
SELECT  (COLUNA CONDICIONAL COM NUMEROS)
ID,
NAME,
CASE
  WHEN ID BETWEEN 0 AND 3 THEN 'A'
  WHEN ID BETWEEN 4 AND 6 THEN 'B'
  ELSE 'C'
END AS padrao  
FROM `your-project.Vendas.Categoria`
`````


## Reference

- [Big Query Documentation](https://cloud.google.com/bigquery/docs/reference/libraries?hl=pt-br#client-libraries-install-java)
- [Udemy Course](https://meli.udemy.com/course/sql-bigquery/learn/lecture/33665794#overview)


## Autores

- [@stephanierodriguesss](https://www.github.com/stephanierodriguesss)

