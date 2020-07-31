package kr.co.inslab;


import kr.co.inslab.route53.Route53;
import kr.co.inslab.route53.Route53Exception;
import kr.co.inslab.route53.model.Record;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Route53ServiceTest {

    private static final Logger log = LoggerFactory.getLogger(Route53ServiceTest.class);

    @Autowired
    private Route53 route53;

    @Test
    @Order(0)
    public void contextLoads() {
        assertThat(route53).isNotNull();
    }

    @Test
    @Order(1)
    public void getZones() throws Route53Exception {
        route53.getZones("gantry.ai.");
    }
    @Test
    @Order(2)
    public void createZone() throws Route53Exception {
       route53.createZone("test-chan.gantry.ai.");
    }

    @Test
    @Order(3)
    public void createRecord() throws Route53Exception {
        List<Record> records = route53.getRecords("test-chan.gantry.ai.");
        for(Record record : records){
            if(record.getType().equals("NS")){
                record.setTtl((long) 300);
                route53.createRecord("gantry.ai.",record);
            }
        }
    }
    @Test
    @Order(4)
    public void getRecords() throws Route53Exception {
        List<Record> records = route53.getRecords("test-chan.gantry.ai.");
        for(Record record : records){
            log.debug(record.getName());
            log.debug(record.getType());
        }
    }


    @Test
    @Order(4)
    public void deleteRecord() throws Route53Exception {
        route53.deleteRecord("gantry.ai.","test-chan.gantry.ai.","NS");
    }

    @Test
    @Order(5)
    public void deleteZone() throws Route53Exception {
        route53.deleteZone("test-chan.gantry.ai.");
    }
}
