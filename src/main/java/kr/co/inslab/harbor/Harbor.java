package kr.co.inslab.harbor;

import kr.co.inslab.harbor.model.HarborProject;

import java.util.List;

public interface Harbor {
    void createProject(String projectName);
    List<HarborProject> getProjectByName(String projectName);
    void deleteProject(int projectId);
}
