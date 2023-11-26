# Diocese Santos Backend - Java com Spring Boot

O Backend é a parte do projeto responsável por processar as coordenadas de geolocalização recebidas do aplicativo em React Native. Ele utiliza o framework Spring Boot para fornecer os endpoints necessários para receber as coordenadas, processá-las e retornar informações sobre as igrejas mais próximas que terão missas.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Docker

## Pré requisitos
Necessita ter Java 17, Docker, Maven.

## Execução local subindo o banco

1. Clone este repositório para o seu ambiente de desenvolvimento.

```bash
git clone https://github.com/diocese-santos-org/diocese-santos-backend.git
```

2. Abra seu docker

3. Navegue até o diretório clonado:

```bash
cd nome_do_diretório 
```

4. Execute o script .sh:

```bash
   sh script-banco.sh
```

5. Levantar a aplicação
```bash
./mvnw spring-boot:run
```

## Uso

O backend estará acessível em: `http://localhost:8080`.

Token para acessar recursos protegidos passando sempre como Bearer:

```bash
eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgRW1wcmVzYSBEZXNhZmlvIiwic3ViIjoiZGlvY2VzZXNhbnRvcyIsImlhdCI6MTY5OTIzMjQyMywiZXhwIjoxNzAxMDU5ODEwfQ.dSM04FHQGFIKaN8TDh_Zy9TBtnK-BRAvb_ry5toV2u4
 ```
Acesse `http://localhost:8080/swagger-ui.html` para ver todos os endpoints da aplicação e lembre-se de utilizar a autenticação Bearer