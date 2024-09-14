FROM debian

RUN apt-get update && \
    apt-get upgrade -y && \
    apt-get install -y git && \
    apt-get install -y maven

#RUN git config --global --add safe.directory "*"
RUN git clone https://github.com/YasinDeger48/devops-automation.git

#CMD mvn clean install
#CMD mvn test -Dcucumber.filter.tags='@OK and @workingOnIt'

WORKDIR devops-automation

CMD "mvn test"

