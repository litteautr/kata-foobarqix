FROM alpine:latest

RUN apk update
RUN apk fetch openjdk11
RUN apk add openjdk11

ADD ./target/kata-foobarqix-1.0.jar kata-foobarqix.jar

CMD java -jar kata-foobarqix.jar