package kr.co.inslab.gantry;

import org.springframework.context.ApplicationEvent;

public class ProjectEvent extends ApplicationEvent {

    private final kr.co.inslab.model.ProjectEvent projectEvent;

    public ProjectEvent(Object source, kr.co.inslab.model.ProjectEvent projectEvent){
        super(source);
        this.projectEvent = projectEvent;
    }

    public String getGantryProjectName() {
        return projectEvent.getGantryProjectName();
    }
    public String getGantryProjectId(){
        return projectEvent.getGantryProjectId();
    }
    public String getEventType(){
        return projectEvent.getEventType();
    }
}
