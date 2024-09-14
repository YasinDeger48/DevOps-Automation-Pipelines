React App Building Phase:
------------------------

Step1: navigate to directory:
------------------------
```
cd /Users/yasindeger/Desktop/DevOps/devops-automation/k8s/kubernetesTutorials/01-ReactApp

```

Step2: build an image:
------------------------
```
docker build -t yasindeger48/react-app .

```

Step3: push image to docker hub
------------------------
```
docker push yasindeger48/react-app
```
Kubernetes Expose Phase:
------------------------

Step4: create a deployment
------------------------
```
kubectl create deployment my-react-site --image=yasindeger48/react-app
or
kubectl apply -f react-deployment.yaml 
```

Step5: Expose and create a service over deployment
------------------------
```
kubectl expose deployment my-react-site --type="NodePort" --port 80
kubectl expose deployment/my-react-site --type="NodePort" --port 80
or
kubectl apply -f react-service.yaml 

```

Step6: Check services if create successfully get url over minikube
------------------------
```
minikube service my-react-site --url

```