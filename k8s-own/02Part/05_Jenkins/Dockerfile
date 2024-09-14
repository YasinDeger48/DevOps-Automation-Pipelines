FROM jenkins/jenkins

# Maven kurulumu
USER root
RUN apt-get update -y \
    && apt-get install -y maven \
    && apt-get clean \
    && rm -rf /var/lib/apt/lists/*

# Maven ve Playwright çevre değişkenleri
ENV MAVEN_HOME /usr/share/maven
ENV PATH $MAVEN_HOME/bin:$PATH

# Playwright kütüphanelerini yükleme
# Maven proje kök dizininde yer alan pom.xml dosyasında Playwright bağımlılığı bulunmalıdır
# Bu komut, Maven ile Playwright bağımlılıklarını yükler
RUN mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install --with-deps"

# Jenkins kullanıcısına geri dön
USER jenkins
