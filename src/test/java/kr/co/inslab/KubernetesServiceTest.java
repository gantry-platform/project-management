package kr.co.inslab;

import kr.co.inslab.kubernetes.Kubernetes;
import kr.co.inslab.kubernetes.KubernetesException;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class KubernetesServiceTest {

    private static final Logger log = LoggerFactory.getLogger(KubernetesServiceTest.class);

    @Autowired
    private Kubernetes kubernetes;

    @Test
    @Order(0)
    public void contextLoads() {
        assertThat(kubernetes).isNotNull();
    }

    @Test
    @Order(1)
    public void createNamespace() throws KubernetesException {
        ResponseEntity<Void> responseEntity = kubernetes.createNamespace("1234");
        assertThat( responseEntity.getStatusCode().value()).isEqualTo(201);
    }

    @Test
    @Order(2)
    public void delete() throws KubernetesException {
        ResponseEntity<Void> responseEntity = kubernetes.deleteNamespace("1234");
        assertThat( responseEntity.getStatusCode().value()).isEqualTo(200);
    }

}
