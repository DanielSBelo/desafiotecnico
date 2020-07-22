FROM openjdk:8

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /opt/desafiotecnico

COPY /target/desafiotecnico*.jar desafiotecnico.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 5005
EXPOSE 8080

CMD java ${ADDITIONAL_OPTS} -jar desafiotecnico.jar --spring.profiles.active=${PROFILE}