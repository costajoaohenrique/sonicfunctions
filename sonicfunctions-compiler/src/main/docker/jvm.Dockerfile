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
# mvn package -Dmaven.test.skip=true && docker build -f src/main/docker/jvm.Dockerfile -t quarkus/sonicfunctions-compiler-jvm . && docker run --rm -it -p 8080:8080 --name compiler_container --network=postgres-network quarkus/sonicfunctions-compiler-jvm
#
#

###
FROM costajoaohenrique/sonicfunctions:base-graalvm-19.2.0
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV AB_ENABLED=jmx_exporter
COPY target/lib/* /deployments/lib/
COPY target/*-runner.jar /deployments/app.jar
ENTRYPOINT ["java", "-jar", "deployments/app.jar"]