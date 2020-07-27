package kr.co.inslab.kubernetes;


import kr.co.inslab.kubernetes.model.data.KubernetesNamespaceInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KubernetesRepository extends MongoRepository<KubernetesNamespaceInfo, String> {
    KubernetesNamespaceInfo findKubernetesNamespaceInfoByGantryProjectId(String gantryProjectId);
}
