FROM debian

#COPY ./ ./TEST_FOLDER
COPY ./src /TEST_FOLDER/src
COPY ./pom.xml /TEST_FOLDER

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git && \
    apt-get install -y maven

WORKDIR TEST_FOLDER

ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=$PATH:/opt/maven/bin

#CMD mvn test

#ENTRYPOINT ["mvn","clean","install","test"]

CMD ["mvn", "clean", "install", "test"]

