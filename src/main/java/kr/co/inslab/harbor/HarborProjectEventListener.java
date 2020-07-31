package kr.co.inslab.harbor;

import kr.co.inslab.gantry.ProjectEvent;
import kr.co.inslab.gantry.data.GantryInfo;
import kr.co.inslab.harbor.model.HarborProject;
import kr.co.inslab.harbor.model.data.HarborProjectInfo;
import kr.co.inslab.harbor.model.data.HarborProjectInfoHarbor;
import kr.co.inslab.harbor.repository.HarborRepository;
import kr.co.inslab.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDateTime;

import java.util.List;

@Component
public class HarborProjectEventListener implements ApplicationListener<ProjectEvent> {

    private final Logger log = LoggerFactory.getLogger(HarborProjectEventListener.class);

    private final Harbor harbor;

    private final HarborRepository harborRepository;

    public HarborProjectEventListener(Harbor harbor, HarborRepository harborRepository) {
        this.harbor = harbor;
        this.harborRepository = harborRepository;
    }

    @lombok.SneakyThrows
    @Override
    public void onApplicationEvent(ProjectEvent event) {
        String eventType = event.getEventType();

        switch (eventType){
            case CommonConstants.CREATE:
                String docId = this.startCreating(event);
                this.createHarborProject(event,docId);
                break;
            case CommonConstants.DELETE:
                HarborProjectInfo harborProjectInfo = this.startDeleting(event);
                this.deleteHarborProject(harborProjectInfo);
                break;
            default:
                break;
        }
    }

    private String startCreating(ProjectEvent event){

        HarborProjectInfoHarbor harbor = new HarborProjectInfoHarbor();
        harbor.setStatus(CommonConstants.CREATING);
        harbor.setProjectName(event.getGantryProjectName());

        GantryInfo gantry = new GantryInfo();
        gantry.setProjectId(event.getGantryProjectId());

        HarborProjectInfo harborProject = new HarborProjectInfo();
        harborProject.setGantry(gantry);
        harborProject.setHarbor(harbor);

        HarborProjectInfo res = this.harborRepository.save(harborProject);

        return res.getId();
    }

    private HarborProjectInfo startDeleting(ProjectEvent event){
        HarborProjectInfo harborProjectInfo = this.harborRepository.findHarborProjectInfoByGantryProjectId(event.getGantryProjectId());
        harborProjectInfo.getHarbor().setStatus(CommonConstants.DELETING);
        return this.harborRepository.save(harborProjectInfo);
    }

    private void deleteHarborProject(HarborProjectInfo harborProjectInfo) throws HarborException {
        this.harbor.deleteProject(Integer.parseInt(harborProjectInfo.getHarbor().getProjectId()));
        harborProjectInfo.getHarbor().setStatus(CommonConstants.DELETED);
        harborProjectInfo.getHarbor().setDeletedAt(LocalDateTime.now());
        this.harborRepository.save(harborProjectInfo);
    }


    private void createHarborProject(ProjectEvent event,String docId) throws HarborException {
        int harborProjectId = 0;
        String gantryProjectId = event.getGantryProjectId();
        String gantryProjectName = event.getGantryProjectName();

        //create harbor project
        this.harbor.createProject(gantryProjectName);
        //get harbor projectByName for getting id
        List<HarborProject> harborProjects = this.harbor.getProjectByName(gantryProjectName);

        if(harborProjects != null){
            harborProjectId = harborProjects.get(0).getProjectId();
        }

        GantryInfo gantry = new GantryInfo();
        gantry.setProjectId(gantryProjectId);

        HarborProjectInfoHarbor harbor = new HarborProjectInfoHarbor();
        harbor.setCreatedAt(LocalDateTime.now());
        harbor.setProjectId(String.valueOf(harborProjectId));
        harbor.setProjectName(gantryProjectName);
        harbor.setStatus(CommonConstants.CREATED);

        HarborProjectInfo harborProjectInfo = new HarborProjectInfo();
        harborProjectInfo.setGantry(gantry);
        harborProjectInfo.setHarbor(harbor);
        harborProjectInfo.setId(docId);

        this.harborRepository.save(harborProjectInfo);
    }
}
