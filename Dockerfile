FROM debian

COPY ./ ./TEST_FOLDER

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git && \
    apt-get install -y maven

WORKDIR TEST_FOLDER



