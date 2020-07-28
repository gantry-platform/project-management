package kr.co.inslab.kubernetes;

import kr.co.inslab.kubernetes.model.Namespace;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Kubernetes {
    ResponseEntity<Void> createNamespace(String name) throws KubernetesException;
    ResponseEntity<Void> deleteNamespace(String name) throws KubernetesException;
    ResponseEntity<List<Namespace>> getNamespaces() throws KubernetesException;
}
