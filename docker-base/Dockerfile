####
#   Dockerfile utilizado para buildar a imagem padrão para os containers do sonicfunction
#   
#   A imagem é a base igual ao do quarkus, unica diferença é que junto a JVM será
# instalada o graalvm e suas dependencias para compilação nativa
#
# 
#
#
#
###
FROM fabric8/java-alpine-openjdk8-jre

###################### GRAALVM ####################################
RUN apt-get update && \
    apt-get install -y wget gcc libz-dev && \
    rm -rf /var/lib/apt/lists/*

ARG VERSION=19.2.0
RUN wget https://github.com/oracle/graal/releases/download/vm-$VERSION/graalvm-ce-linux-amd64-$VERSION.tar.gz && \
    tar -xvzf graalvm-ce-$VERSION-linux-amd64.tar.gz && \
    rm graalvm-ce-linux-amd64-$VERSION.tar.gz && \
    /graalvm-ce-$VERSION/bin/gu install native-image

ENV PATH=/graalvm-ce-$VERSION/bin:$PATH

###################### GRAALVM ####################################
