# Usa uma imagem do Java como base
FROM eclipse-temurin:17-jdk-jammy

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo .jar gerado pelo Maven para dentro da imagem
COPY target/*.jar app.jar

# Expõe a porta que sua aplicação usa (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]