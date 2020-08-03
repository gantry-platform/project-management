package kr.co.inslab.kubernetes;

import kr.co.inslab.kubernetes.model.Namespace;

import java.util.List;

public interface Kubernetes {
    void createNamespace(String name) throws KubernetesException;
    void deleteNamespace(String name) throws KubernetesException;
    List<Namespace> getNamespaces() throws KubernetesException;
}
