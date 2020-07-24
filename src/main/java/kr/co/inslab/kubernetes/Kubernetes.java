package kr.co.inslab.kubernetes;

import org.springframework.http.ResponseEntity;

public interface Kubernetes {
    ResponseEntity<Void> createNamespace(String name) throws KubernetesException;
    ResponseEntity<Void> deleteNamespace(String name) throws KubernetesException;
}
