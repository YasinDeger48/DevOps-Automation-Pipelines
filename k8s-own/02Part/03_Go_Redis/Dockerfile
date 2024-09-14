# İlk aşama: Go kodunu derleme
FROM golang:1.18 AS builder

WORKDIR /app

# go mod dosyasını başlat
COPY go.mod go.sum ./
CMD go mod download

# Uygulama kodunu kopyala
COPY . .

# Uygulamayı derle
CMD CGO_ENABLED=0 GOOS=linux go build -o main .

# İkinci aşama: Uygulama çalıştırma
FROM scratch
WORKDIR /app

# Derlenmiş uygulamayı kopyala
COPY --from=builder /app/ .

# Statik dosyaları kopyala
COPY ./public/index.html public/index.html
COPY ./public/script.js public/script.js
COPY ./public/style.css public/style.css

# Uygulamayı başlat
CMD ["/app/main"]
EXPOSE 3000
