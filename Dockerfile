FROM adoptopenjdk:11-jre-hotspot
COPY target/XmlConsumer**.jar iAppsBackend.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "iAppsBackend.jar"]