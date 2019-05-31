# MicroProfile generated Application

## Introduction

MicroProfile Starter has generated this MicroProfile application for you.

The generation of the executable jar file can be performed by issuing the following command

    mvn clean package

This will create an executable jar file **register-thorntail-thorntail.jar** within the _target_ maven folder. This can be started by executing the following command

    java -jar target/register-thorntail-thorntail.jar

To launch the test page, open your browser at the following URL

    http://localhost:8080/index.html

## Specification examples

By default, there is always the creation of a JAX-RS application class to define the path on which the JAX-RS endpoints are available.

Also, a simple Hello world endpoint is created, have a look at the class **HelloController**.

More information on MicroProfile can be found [here](https://microprofile.io/)


### Config

Configuration of your application parameters. Specification [here](https://microprofile.io/project/eclipse/microprofile-config)

The example class **ConfigTestController** shows you how to inject a configuration parameter and how you can retrieve it programmatically.



### Fault tolerance

Add resilient features to your applications like TimeOut, RetryPolicy, Fallback, bulkhead and circuit breaker. Specification [here](https://microprofile.io/project/eclipse/microprofile-fault-tolerance)

The example class **ResilienceController** has an example of a FallBack mechanism where an fallback result is returned when the execution takes too long.



### Health

The health status can be used to determine if the 'computing node' needs to be discarded/restarted or not. Specification [here](https://microprofile.io/project/eclipse/microprofile-health)

The class **ServiceHealthCheck** contains an example of a custom check which can be integrated to health status checks of the instance.  The index page contains a link to the status data.



### Metrics

The Metrics exports _Telemetric_ data in a uniform way of system and custom resources. Specification [here](https://microprofile.io/project/eclipse/microprofile-metrics)

The example class **MetricController** contains an example how you can measure the execution time of a request.  The index page also contains a link to the metric page (with all metric info)



### JWT Auth

Using the OpenId Connect JWT token to pass authentication and authorization information to the JAX-RS endpoint. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

Have a look at the **JWTClient** class within the test directory which calls the protected endpoint on the server from a Java Main method.
The **ProtectedController** contains the protected endpoint since it contains the _@RolesAllowed_ annotation on the JAX-RS endpoint method.

In order to call the protected endpoint, a separate program (see _JWTClient_) is used to simulate as much as possible a real world situation. A JAX-RS client implementation is used for this purpose to match the selected MicroProfile implementation, with an arbitrary version.
However, any method to send a REST request with an appropriate header will work of course. Please feel free to change this code to your needs.




### Open API

Exposes the information about your endpoints in the format of the OpenAPI v3 specification. Specification [here](https://microprofile.io/project/eclipse/microprofile-open-api)

The index page contains a link to the OpenAPI information of your endpoints.




### Open Tracing

Allow the participation in distributed tracing of your requests through various micro services. Specification [here](https://microprofile.io/project/eclipse/microprofile-opentracing)

Example needs to be created.




### Rest Client

A type safe invocation of HTTP rest endpoints. Specification [here](https://microprofile.io/project/eclipse/microprofile-rest-client)

Example needs to be created.



### Debug in VSCode

Alterar launch.json

    "version": "0.2.0",
        "configurations": [
            {
                "type": "java",
                "name": "Debug (Attach)",
                "request": "attach",
                "hostName": "127.0.0.1",
                "port": 5005
            }

Executar o comando abaixo para executar attached no VSCode

    java -Xdebug -Xrunjdwp:transport=dt_socket,server=y,address=5005,suspend=y -jar target/register-thorntail-thorntail.jar





curl -H "Content-Type: application/json" -X POST -d '{"id":"1","name":"sum", "body":"1+1" "type":"javascript"}' http://localhost:8080/functions




curl -H "Content-Type: application/json" -X POST -d '{"id":"1","author":"Krochmalski", "title":"IDEA"}' http://localhost:8080/books

curl -s http://localhost:8080/api/v1/namespaces/default/services -XPOST -H 'Content-Type: application/json' -d@service.json

curl -s http://localhost:8080/apis/extensions/v1beta1/namespaces/default/deployments -XPOST -H 'Content-Type: application/json' -d@deployment.json

https://192.168.99.100:8443/api/v1/namespaces/default/pods curl http://localhost:8080/api/v1/namespaces/default/pods

