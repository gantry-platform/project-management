package kr.co.inslab.kubernetes;

import kr.co.inslab.gantry.ProjectEvent;
import kr.co.inslab.gantry.data.GantryInfo;
import kr.co.inslab.harbor.HarborException;
import kr.co.inslab.harbor.model.data.HarborProjectInfo;
import kr.co.inslab.kubernetes.model.data.KubernetesNamespaceInfo;
import kr.co.inslab.kubernetes.model.data.KubernetesNamespaceInfoKubernetes;
import kr.co.inslab.utils.CommonConstants;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDateTime;

@Component
public class KubernetesProjectEventListener implements ApplicationListener<ProjectEvent> {

    private final Logger log = LoggerFactory.getLogger(KubernetesProjectEventListener.class);

    private final Kubernetes kubernetes;

    private final KubernetesRepository kubernetesRepository;

    public KubernetesProjectEventListener(Kubernetes kubernetes, KubernetesRepository kubernetesRepository) {
        this.kubernetes = kubernetes;
        this.kubernetesRepository = kubernetesRepository;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ProjectEvent event) {
        String eventType = event.getEventType();

        switch (eventType){
            case CommonConstants.CREATE:
                String docId = this.startCreating(event);
                this.createNamespace(event,docId);
                break;
            case CommonConstants.DELETE:
                KubernetesNamespaceInfo kubernetesNamespaceInfo = this.startDeleting(event);
                this.deleteKubernetesNamespace(kubernetesNamespaceInfo);
                break;
            default:
                break;
        }
    }

    private KubernetesNamespaceInfo startDeleting(ProjectEvent event){
        KubernetesNamespaceInfo kubernetesNamespaceInfo = this.kubernetesRepository.findKubernetesNamespaceInfoByGantryProjectId(event.getGantryProjectId());
        kubernetesNamespaceInfo.getKubernetes().setStatus(CommonConstants.DELETING);
        return this.kubernetesRepository.save(kubernetesNamespaceInfo);
    }

    private void deleteKubernetesNamespace(KubernetesNamespaceInfo kubernetesNamespaceInfo) throws KubernetesException {
        this.kubernetes.deleteNamespace(kubernetesNamespaceInfo.getKubernetes().getName());
        kubernetesNamespaceInfo.getKubernetes().setStatus(CommonConstants.DELETE_IN_PROGRESS);
        this.kubernetesRepository.save(kubernetesNamespaceInfo);
    }

    private String startCreating(ProjectEvent event) {
        String gantryProjectId = event.getGantryProjectId();
        String gantryNamespaceName = event.getGantryProjectName();

        GantryInfo gantryInfo = new GantryInfo();
        gantryInfo.setProjectId(gantryProjectId);

        KubernetesNamespaceInfoKubernetes kubernetesNamespace = new KubernetesNamespaceInfoKubernetes();
        kubernetesNamespace.setStatus(CommonConstants.CREATING);
        kubernetesNamespace.setName(gantryNamespaceName);

        KubernetesNamespaceInfo namespaceInfo = new KubernetesNamespaceInfo();
        namespaceInfo.setGantry(gantryInfo);
        namespaceInfo.setKubernetes(kubernetesNamespace);

        KubernetesNamespaceInfo res = this.kubernetesRepository.save(namespaceInfo);
        return res.getId();
    }

    private void createNamespace(ProjectEvent event,String docId) throws KubernetesException {
        String gantryProjectId = event.getGantryProjectId();
        String gantryProjectName = event.getGantryProjectName();

        this.kubernetes.createNamespace(gantryProjectName);

        GantryInfo gantryInfo = new GantryInfo();
        gantryInfo.setProjectId(gantryProjectId);

        KubernetesNamespaceInfoKubernetes kubernetesNamespace = new KubernetesNamespaceInfoKubernetes();
        kubernetesNamespace.setCreatedAt(LocalDateTime.now());
        kubernetesNamespace.setName(gantryProjectName);
        kubernetesNamespace.setStatus(CommonConstants.CREATE_IN_PROGRESS);

        KubernetesNamespaceInfo namespaceInfo = new KubernetesNamespaceInfo();
        namespaceInfo.setGantry(gantryInfo);
        namespaceInfo.setKubernetes(kubernetesNamespace);
        namespaceInfo.setId(docId);

        kubernetesRepository.save(namespaceInfo);
    }
}
