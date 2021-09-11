# back
FROM openjdk:11

LABEL maintainer="iamanaev2001@gmail.com"
VOLUME /tmp

EXPOSE 8099

ARG JAR_FILE=books-service-api.jar
ADD ${JAR_FILE} app.jar
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh
CMD ["/entrypoint.sh"]