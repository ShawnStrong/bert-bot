FROM gradle:6.5.0-jdk11

COPY . /usr/src/bert
WORKDIR /usr/src/bert
RUN gradle build --no-daemon

RUN pkill -f 'java -jar'

FROM openjdk:11

ENTRYPOINT ["java", "-jar", "/usr/src/bert/build/libs/bert-1.0-SNAPSHOT-all.jar"]