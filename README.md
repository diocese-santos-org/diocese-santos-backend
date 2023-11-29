# Diocese Santos Backend - Java com Spring Boot

O Backend é a parte do projeto responsável por processar as coordenadas de geolocalização recebidas do aplicativo em React Native. Ele utiliza o framework Spring Boot para fornecer os endpoints necessários para receber as coordenadas, processá-las e retornar informações sobre as igrejas mais próximas que terão missas.

## Integrantes
> - Carlos Eduardo Lorenzetti Júnior
> - Elián Roventini de Andrade - [Linkedin - Elián Andrade](https://www.linkedin.com/in/elianroventini/)
> - Gabriel Souza Recouso - [Linkedin - Gabriel Recouso](https://www.linkedin.com/in/gabrielrecouso/)
> - Gustavo Lino Barbosa - [Linkedin - Gustavo Barbosa](https://www.linkedin.com/in/gustavobarb/)
> - Lara Iasmine Pedroso Fabiano - [Linkedin - Lara Iasmine](https://www.linkedin.com/in/lara-iasmine-fabiano/)
> - Leonardo Ribeiro Blume - [Linkedin - Leonardo Blume](https://www.linkedin.com/in/leonardo-blume-5484311b5/)
> - Matheus La Scala Candido da Costa - [Linkedin - Matheus La Scala](https://www.linkedin.com/in/matheus-la-scala-1a1b091b0/)
> - Tiago Samuel Sousa dos Santos - [Linkedin - Tiago Samuel](https://www.linkedin.com/in/tiagosts99)

## Índice

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré requisitos](#pré-requisitos)
- [Execução local subindo o banco](#execução-local-subindo-o-banco)
- [Uso](#uso)
- [Token](#token)
- [Documentação](#documentação)
- [Collection](#collection)
- [Links Importantes](#links-importantes)

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

O backend estará acessível em: `http://localhost:8080 = {urlLocal}`. 

Caso queira mudar a porta, modificar a server.port=8080 para a porta deseada


### Token
Token para acessar esta disponivel para ser gerado na url:`{urlLocal}/token`

### Documentação: 
Acesse `{urlLocal}/swagger-ui.html` para ver todos os endpoints da aplicação e lembre-se de utilizar a autenticação Bearer

### Collection
A [collection]( ./collection) do insomnia foi exportada para esta pasta.


As urls estão com Enviroments, para adcionar basta colar esse json: 

```bash
{
	"url": "http://localhost:",
	"porta": "8080"
}
```

### Links Importantes
- WIKI do projeto: https://github.com/diocese-santos-org/diocese-santos-wiki/wiki
- Front-End do projeto: https://github.com/diocese-santos-org/diocese-santos-front
