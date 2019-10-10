####
# This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode
#
# Before building the docker image run:
#
# mvn package
#
# Then, build the image with:
#
# docker build -f src/main/docker/jvm.Dockerfile -t quarkus/sonicfunctions-compiler-jvm .
#
# Then run the container using:
#
# docker run -i --rm -p 8080:8080 quarkus/sonicfunctions-compiler-jvm
#
#
# mvn package -Dmaven.test.skip=true && docker build -f src/main/docker/jvm.multistage.Dockerfile -t quarkus/sonicfunctions-compiler-jvm . && docker run --rm -it -p 8080:8080 --name compiler_container --network=postgres-network quarkus/sonicfunctions-compiler-jvm
#
#

###
## Stage 1 : build with maven builder image with native capabilities
FROM quay.io/quarkus/centos-quarkus-maven:19.2.0.1 AS build
COPY settings.xml /usr/share/maven/conf
RUN mkdir temp && cd temp && mvn io.quarkus:quarkus-maven-plugin:0.23.2:create \
    -DprojectGroupId=org.acme \
    -DprojectArtifactId=getting-started \
    -DclassName="org.acme.quickstart.GreetingResource" \
    -Dpath="/hello" \
    && mvn package -Dmaven.test.skip=true
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN mvn -f /usr/src/app/pom.xml clean package


FROM costajoaohenrique/sonicfunctions:base-graalvm-19.2.0
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter
COPY target/lib/* /deployments/lib/
COPY --from=build /usr/src/app/target/* /deployments/
ENTRYPOINT ["java", "-jar", "deployments/app.jar"]