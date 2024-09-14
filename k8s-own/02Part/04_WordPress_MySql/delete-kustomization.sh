#!/bin/sh

# Deployment'ları silme komutları
kubectl delete deployment wordpress-mysql
kubectl delete deployment wordpress

# Service'şeri silme komutları
kubectl delete service wordpress-mysql
kubectl delete service wordpress

#check
kubectl get deployments
kubectl get services
kubectl get pods

