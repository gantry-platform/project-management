package kr.co.inslab.kubernetes;

import kr.co.inslab.kubernetes.model.NewNamespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class KubernetesService implements Kubernetes{
    private final Logger log = LoggerFactory.getLogger(KubernetesService.class);

    private final RestTemplate restTemplate;

    @Value("${k8s.api.endpoint}")
    private String K8S_API_ENDPOINT;

    public KubernetesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void createNamespace(String name) {
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));

        //set body
        NewNamespace newNamespace = new NewNamespace();
        newNamespace.setName(name);

        //send request
        HttpEntity<NewNamespace> httpEntity = new HttpEntity<>(newNamespace,httpHeaders);
        ResponseEntity<Void> res = this.restTemplate.postForEntity(K8S_API_ENDPOINT+"/namespaces",httpEntity,Void.class);

    }
}
