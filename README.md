### Prerequirements
* docker (v20.10.17) [install](https://docs.docker.com/engine/install/)
* enable kubernetes (v1.25.0) in docker preference
* Test under macOS Monterey 12.6, CPU: 1.4GHz Interl Core i5 / RAM: 16GB 2133MHz LPDDR3

### pack spring boot & build image, then push image to docker hub  
```
$ cd springio-api
$ docker build -t springio-demo .

# this image tag and "image" (in k8s-app/deployment.yaml) should be identical
#
$ docker login
$ docker tag springio-demo ${your_docker_hub}/springio-demo:1.0.0
$ docker push ${your_docker_hub}/springio-demo:1.0.0
```

### check k8s cluster status  
```
$ kubectl cluster-info
$ kubectl get nodes
$ kubectl get services
```

### apply all service (app & mysql)  
```
$ cd ..
$ kubectl apply -f base
$ kubectl apply -f mysql
$ kubectl apply -f springio-api/k8s-app
```

### check service,pod status  
```
$ kubectl get svc,pods -n springio
```

### or using kubernetes proxy
```
# open browser: http://localhost:8080/swagger-ui.html
# Forward one or more local ports to a pod.
$ kubectl port-forward -n springio svc/springio-demo 8080:8080
```


========================== reset ===============================
### delete all in namespace "springio" & PV  
```
# 所有跟springio namespaces相關的resource一起砍掉 (像GCP把整個PROJECT砍掉)
$ kubectl delete namespaces springio
$ kubectl delete pv mysql-pv --grace-period=0 --force
```

========================== debug ===============================
### debug pod & check pod logs  
```
$ kubectl describe pods ${POD_NAME} -n springio 
$ kubectl logs ${POD_NAME} -n springio   
```


### look inside mysql  
```
$ kubectl -n springio exec -it ${MYSQL_POD_NAME} -- mysql -u root -p
```

### if pods stuck in terminating status  
```
$ kubectl delete pod <PODNAME> --grace-period=0 --force -n springio  
```