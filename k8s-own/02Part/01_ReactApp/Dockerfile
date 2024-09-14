# Temel image olarak Node.js veya nginx kullanabilirsiniz ?? doesnt matter
FROM node:14 AS build

# Uygulama dizinine geçiyoruz
WORKDIR 01_ReactApp

# package.json ve package-lock.json dosyalarını kopyalayoruz
COPY package*.json ./

# Bağımlılıkları yüklüyoruz
RUN npm install

# Tüm dosyaları kopyala ve uygulamayı build et !!!
COPY ./ .
RUN npm run build

# Prod aşamasına geçip nginx kullanarak sunacağız
FROM nginx:alpine
COPY --from=build /01_ReactApp/build /usr/share/nginx/html

# Nginx'in default ayarları ile çalıştır
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]

#CMD ["nginx", "-g", "daemon off;"] komutu, Docker konteyneri içinde nginx web sunucusunu başlatmak için kullanılır.
#
#Buradaki -g "daemon off;" ifadesi, nginx’in arka planda (daemon) çalışmasını engelleyip, ön planda çalışmasını sağlar.
#Bunun amacı, Docker konteyneri çalışırken nginx sürecinin ana süreç olarak çalışmasını sağlamaktır.
#Eğer nginx arka planda çalışsaydı, konteyner nginx'in çalıştığını anlamaz ve konteyner kapanabilirdi.
#
#Özetle:
#
#nginx: nginx web sunucusunu başlatır.
#-g "daemon off;": Nginx'in arka planda değil, ön planda çalışmasını sağlar, böylece konteyner kapanmaz.
