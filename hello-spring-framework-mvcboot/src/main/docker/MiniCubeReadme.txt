# Start minicube cluster
sudo minikube start 

# Check environment
sudo kubectl config view
sudo kubectl version
minikube status
minikube ip
sudo minikube ssh

minikube addons list
sudo minikube dashboard  <-- enable dashboard if needed


# Deploy sme/simple-mvc-boot:0.1 docker in minicube
cd HelloSpringFramework/hello-spring-framework-mvcboot/src/main/docker 
ls -l | grep simple
 
# Start simple-mvcboot pod:
sudo kubectl create -f simple-mvcboot-pod.yaml

-- get and describe pod
sudo kubectl get pods | grep simple-mvcboot
sudo kubectl describe pod simple-mvcboot

# Start service
sudo kubectl create -f simple-mvcboot-service.yaml

-- get and describe service
sudo kubectl get services
sudo kubectl describe svc simple-mvcboot
> Labels:                 app=simple-mvcboot
> Selector:               app=simple-mvcboot
> Type:                   LoadBalancer
> IP:                     10.110.104.101
> Port:                   http    8040/TCP
> NodePort:               http    31596/TCP
> Endpoints:              <none>

# Start Replication Controller
sudo kubectl create -f simple-mvcboot-replicationcontroller.yaml

-- get info
sudo kubectl get rc
kubectl get pods  <-- fetch pods + replication controller with all replicas
sudo kubectl describe svc simple-mvcboot
> Labels:                 app=simple-mvcboot
> Selector:               app=simple-mvcboot
> Type:                   LoadBalancer
> IP:                     10.110.104.101
> Port:                   http    8040/TCP
> NodePort:               http    31596/TCP
> Endpoints:              172.17.0.10:8040,172.17.0.9:8040
 
Open in browser: http://172.17.0.10:8040 or http://172.17.0.9:8040  <-- application should answer properly

# check logs
sudo kubectl logs simple-mvcboot

# check all started images
sudo docker ps | grep simple-mvcboot

# connect to a running image
sudo docker exec -it k8s_simple-mvcboot_simple-mvcboot-n5xf8_default_5d630cbc-a394-473f-adcb-5021b830eb60_0 bash
> ps aux
> exit



# CleanUp
kubectl delete -f simple-mvcboot-replicationcontroller.yaml
kubectl delete -f simple-mvcboot-service.yaml
kubectl delete -f simple-mvcboot-pod.yaml 
