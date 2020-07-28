package kr.co.inslab.kubernetes;

import kr.co.inslab.kubernetes.model.Namespace;
import kr.co.inslab.kubernetes.model.NewNamespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
    public ResponseEntity<Void> createNamespace(String name) throws KubernetesException {
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        //set body
        NewNamespace newNamespace = new NewNamespace();
        newNamespace.setName(name);

        //send request
        HttpEntity<NewNamespace> httpEntity = new HttpEntity<>(newNamespace,httpHeaders);
        ResponseEntity<Void> responseEntity =
                this.restTemplate.postForEntity(K8S_API_ENDPOINT+"/namespaces",httpEntity,Void.class);

        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new KubernetesException(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<Void>  deleteNamespace(String name) throws KubernetesException {
        ResponseEntity<Void> responseEntity =
                this.restTemplate.exchange(K8S_API_ENDPOINT+"/namespaces/{name}", HttpMethod.DELETE,null,Void.class,name);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new KubernetesException(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }

        return responseEntity;
    }

    @Override
    public ResponseEntity<List<Namespace>> getNamespaces() throws KubernetesException {
        return this.restTemplate.exchange(K8S_API_ENDPOINT+"/namespaces", HttpMethod.GET,null,new ParameterizedTypeReference<List<Namespace>>(){});
    }
}
