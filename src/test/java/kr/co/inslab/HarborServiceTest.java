package kr.co.inslab;


import kr.co.inslab.harbor.Harbor;
import kr.co.inslab.harbor.model.HarborProject;
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
public class HarborServiceTest {

    private static final Logger log = LoggerFactory.getLogger(HarborServiceTest.class);

    @Autowired
    private Harbor harborProject;

    public static String projectName = "test_harbor_project";
    public static int projectId;

    @Test
    @Order(0)
    public void contextLoads() {
        assertThat(harborProject).isNotNull();
    }

    @Test
    @Order(1)
    public void createHarborProject() {
        harborProject.createProject(projectName);
    }

    @Test
    @Order(2)
    public void getHarborProjects() {
        List<HarborProject> harborProjects = harborProject.getProjectByName(projectName);
        String resProjectName = harborProjects.get(0).getName();
        assertThat(resProjectName).isEqualTo(projectName);
        projectId = harborProjects.get(0).getProjectId();
        log.debug("projectId:"+projectId);
    }

    @Test
    @Order(3)
    public void deleteHarborProject(){
        harborProject.deleteProject(projectId);
    }
}