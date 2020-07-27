package kr.co.inslab.model;

public class ProjectEvent {

    private final String eventType;
    private final String gantryProjectId;
    private final String gantryProjectName;

    public ProjectEvent(String eventType, String gantryProjectId, String gantryProjectName){
        this.eventType = eventType;
        this.gantryProjectId = gantryProjectId;
        this.gantryProjectName = gantryProjectName;
    }

    public String getEventType() {
        return eventType;
    }

    public String getGantryProjectName() {
        return gantryProjectName;
    }

    public String getGantryProjectId(){
        return gantryProjectId;
    }
}
