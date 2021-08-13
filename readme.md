# Módulos do projeto
## São 3 módulos:
-  **cvcbackendhotel-client-http**: CLiente para acessar a aplicação da CVC no Heroku. Desenvolvida para modularizar. Possui dois testes.

-  **leisure-travel-canonical**: Utilizado a ideia de modelo canônico, aqui atua mais como um DTO.

-  **leisure-travel-api**: A API em si. Possui 5 módulos:

	- **leisure-travel-api**: Módulo que possui os controllers da API

	-  **leisure-travel-service**: Módulo que possui os serviços

	-  **leisure-travel-assembler**: Módulo que possui os assemblers para converter entre entidade e resources

	-  **leisure-travel-model**: Módulo que possui os models

	-  **leisure-travel-repository-nosql**: Módulo que possui os repositories

  

# Pré-Requisitos

- Possuir o Redis instalado e configurado.

- Possuir o Postman ou qualquer outra ferramenta para efetuar consultas em APIs instalada e configurada.

  

# Redis

    redis:
    
    host: localhost
    
    port: 6379
    
    database: 1

  

# Collections do Postman

- No diretório raiz do projeto leisure-travel-api existe um diretório com a collection para ser importada no Postman.

  

# Funcionamento

- Importar para o STS e rodar a aplicação

**PS:** Não subi para um PAAS/SAAS ainda

  

# Swagger

- Endereço: http://localhost:8080/swagger-ui/

  

# Requisições

- Efetua uma busca pelo código da cidade: http://localhost:8080/hotels/city/1032

- Efetua uma busca pelo código do hotel: http://localhost:8080/hotels/1