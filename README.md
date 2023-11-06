# Diocese Santos Backend - Java com Spring Boot

O Backend é a parte do projeto responsável por processar as coordenadas de geolocalização recebidas do aplicativo em React Native. Ele utiliza o framework Spring Boot para fornecer os endpoints necessários para receber as coordenadas, processá-las e retornar informações sobre as igrejas mais próximas que terão missas.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Docker
- Mysql

## Pré requisitos
Necessita ter Java 11, Docker, Maven.

## Execução local subindo o banco

1. Clone este repositório para o seu ambiente de desenvolvimento.

```bash
git clone https://github.com/LeoRBlume/diocese-santos-backend.git 
```
2. Navegue até o diretório clonado:

```bash
cd nome_do_diretório 
```

3. Execute o script .sh:

```bash
   sh script-banco.sh
```

4. Levantar a aplicação
```bash
./mvnw spring-boot:run
```

## Uso

O backend estará acessível em: `http://localhost:8080`.



Utilize o endpoint `/paroquias/geo` com um método GET para enviar as coordenadas de geolocalização passando por Query param latitude e longitude

Token para acessar recursos protegidos:

```bash
eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgRW1wcmVzYSBEZXNhZmlvIiwic3ViIjoiZGlvY2VzZXNhbnRvcyIsImlhdCI6MTY5OTIzMjQyMywiZXhwIjoxNzAxMDU5ODEwfQ.dSM04FHQGFIKaN8TDh_Zy9TBtnK-BRAvb_ry5toV2u4
 ```

O backend processará as coordenadas e retornará informações sobre as igrejas mais próximas que e os horarios das missas.

Exemplo de uso com cURL:

```bash
curl --request GET \
  --url 'http://localhost:8080/paroquias/geo?latitude=-23.938525&longitude=-46.418176' \
  --header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJBUEkgRW1wcmVzYSBEZXNhZmlvIiwic3ViIjoiZGlvY2VzZXNhbnRvcyIsImlhdCI6MTY5OTIzMjQyMywiZXhwIjoxNzAxMDU5ODEwfQ.dSM04FHQGFIKaN8TDh_Zy9TBtnK-BRAvb_ry5toV2u4' \
 ```


