# Use maven to compile the java application.
FROM maven:3.8.6-openjdk-8-slim AS build-env

#-p 旗標會建立 /opt、/opt/app 及 /opt/app/build 目錄（如果這些目錄不存在的話）。
RUN mkdir -p /opt/app/build
WORKDIR /opt/app/build

COPY . ./
RUN mvn -Dmaven.test.skip=true package

# Build runtime image.
FROM openjdk:8-jre-alpine

WORKDIR /opt/app
COPY --from=build-env /opt/app/build/target/*.jar /opt/app/app.jar

# 啟動容器時傳遞參數 使用「java -jar」指令來執行確認jar檔可否正常運行
ENTRYPOINT ["java","-jar","app.jar"]