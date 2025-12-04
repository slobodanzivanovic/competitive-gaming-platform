FROM registry.access.redhat.com/ubi9/openjdk-21:1.23

ENV LANGUAGE='en_US:en'


# We make four distinct layers so if there are application changes the library layers can be re-used
COPY --chown=1000 target/quarkus-app/lib/ /deployments/lib/
COPY --chown=1000 target/quarkus-app/*.jar /deployments/
COPY --chown=1000 target/quarkus-app/app/ /deployments/app/
COPY --chown=1000 target/quarkus-app/quarkus/ /deployments/quarkus/
COPY --chown=1000 target/lib/run-java-sh/fp-files/ /deployments/run/

EXPOSE 8080
USER 1000
ENV JAVA_OPTIONS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_DIR="/deployments"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

WORKDIR /deployments
ENTRYPOINT ["sh", "/deployments/run/run-java.sh"]
