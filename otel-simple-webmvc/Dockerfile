FROM openjdk:11
VOLUME /tmp
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/otel-simple-webmvc-0.0.1-SNAPSHOT.jar /usr/local/agent/app.jar
COPY opentelemetry-javaagent.jar /usr/local/agent/opentelemetry-javaagent.jar
ENTRYPOINT [ "sh", "-c", "java  -javaagent:/usr/local/agent/opentelemetry-javaagent.jar -Dotel.resource.attributes=service.name=otel-simple-webmvc -Dotel.logs.exporter=otlp -Dotel.exporter.otlp.endpoint=http://localhost:4317  -jar /usr/local/agent/app.jar" ]
