####
#   Dockerfile utilizado para buildar a imagem padrão para os containers do sonicfunction
#   
#   A imagem é a base igual ao do quarkus, unica diferença é que junto a JVM será
# instalada o graalvm e suas dependencias para compilação nativa
#
#  docker build -f docker-base/Dockerfile -t costajoaohenrique/sonicfunctions:base-graalvm-19.2.0 .
#  docker push costajoaohenrique/sonicfunctions:base-graalvm-19.2.0
#
###
FROM oracle/graalvm-ce
ARG VERSION=19.2.0
RUN gu install native-image \
    && gu install R
