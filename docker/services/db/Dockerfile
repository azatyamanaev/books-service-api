FROM postgres:11.13-buster

COPY /sql/schema.sql /docker-entrypoint-initdb.d/schema.sql
COPY /sql/init-data.sql /docker-entrypoint-initdb.d/init-data.sql
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=books_service_db
ENV POSTGRES_PASSWORD=postgres



EXPOSE 5432
