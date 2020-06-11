FROM gradle:6.5.0-jdk11
RUN gradle build --no-daemon