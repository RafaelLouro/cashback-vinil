FROM java:8-jre

ADD ./target/venda-service-1.0.1.jar /app/
CMD ["java", "-Xmx200m", "-Dspring.profiles.active=prod", "-jar", "/app/venda-service-1.0.1.jar"]

HEALTHCHECK --interval=30s --timeout=30s CMD curl -f http://localhost:8080/actuator/health || exit 1

EXPOSE 8080