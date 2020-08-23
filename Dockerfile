FROM java:8

WORKDIR /app/

COPY target/web-exec.jar .

CMD ["java", "-jar", "web-exec.jar"]