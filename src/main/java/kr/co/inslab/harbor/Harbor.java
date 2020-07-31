package kr.co.inslab.harbor;

import kr.co.inslab.harbor.model.HarborProject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Harbor {
    void createProject(String projectName) throws HarborException;
    List<HarborProject> getProjectByName(String projectName) throws HarborException;
    void deleteProject(int projectId) throws HarborException;
}
