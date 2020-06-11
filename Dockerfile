FROM gradle:6.5.0-jdk11

WORKDIR /usr/src/bert

COPY . .
RUN gradle build --no-daemon

CMD gradle run