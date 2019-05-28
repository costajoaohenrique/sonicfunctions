# The Sonic Functions Project


## O Projeto

Esse projeto visa a criação de sistema distribuído em arquitetura de microserviços voltado para nuvem utilizando as stacks Java mais atuais do mercado. O projeto será concebido em formato OpenSource com a proposta inicial de estudos para aprofundamento de conceitos e componentes **Cloud Native**.

## A Ideia

A ideia desse projeto é a construção de um sistemas de compilação e execução de funções multilinguagem moldado com base no novo compilador Java GraalVM utilizando framework [Quarkus](https://quarkus.io/) como core do sistema. Utilizaremos a fundo o compilador GraalVM para criar e executar funções poliglotas e com alta performance pois será compilado para linguagem nativa (do próprio SO) sendo containerizado e fácil de escalar.


## Arquitetura

O sistema deve seguir padrões de microserviços tais como **Fault Tolerance**, **Health Check**, **Circuit Breaker** dentre outros.
Será facilmente implantado em arquiteturas baseados em docker e Kubernetes. Parte do sistema (Não obrigatoriamente ser o todo) deverá também ser reativo seguindo fortemente os conceitos do  [The Reactive Manifesto](https://www.reactivemanifesto.org/)

Para auxiliar na adoção desses padrões será utilizado as seguintes stacks:

* Microprofile com Thorntail (Microservices)
* Quarkus 
* Eclipse Vert.x (Reactive)
* Apache Camel (Integração entre os serviços)
* Spring Boot
* Netflix OSS (Stack de auxilio a Microservices)
* Dentre outros...



