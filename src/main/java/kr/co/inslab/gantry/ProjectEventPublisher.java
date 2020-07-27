package kr.co.inslab.gantry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class ProjectEventPublisher {

    @Autowired
    private final ApplicationEventPublisher applicationEventPublisher;

    public ProjectEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void eventPublish(final kr.co.inslab.model.ProjectEvent projectEvent){
        ProjectEvent projectCreateEvent = new ProjectEvent(this,projectEvent);
        this.applicationEventPublisher.publishEvent(projectCreateEvent);
    }
}
