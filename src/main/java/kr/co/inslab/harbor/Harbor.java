package kr.co.inslab.harbor;

import kr.co.inslab.harbor.model.HarborProject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Harbor {
    ResponseEntity<Void> createProject(String projectName) throws HarborException;
    List<HarborProject> getProjectByName(String projectName) throws HarborException;
    ResponseEntity<Void>  deleteProject(int projectId) throws HarborException;
}
