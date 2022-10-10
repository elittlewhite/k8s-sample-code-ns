# you might need to push image to your own docker hub
#cd springio-api
#mvn clean package -DskipTests=true 
#docker build -t springio-demo .
#docker tag springio-demo re102162189/springio-demo:1.0.0
#docker push re102162189/springio-demo:1.0.0 
#cd ..

kubectl apply -f base
kubectl apply -f mysql  
kubectl apply -f springio-api/k8s-app

#run this after service is ready
#kubectl port-forward -n springio svc/springio-demo 8080:8080
