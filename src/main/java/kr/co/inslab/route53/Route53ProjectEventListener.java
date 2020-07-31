package kr.co.inslab.route53;

import kr.co.inslab.gantry.ProjectEvent;
import kr.co.inslab.gantry.data.GantryInfo;
import kr.co.inslab.route53.model.Record;
import kr.co.inslab.route53.model.Zone;
import kr.co.inslab.route53.model.data.Route53Info;
import kr.co.inslab.route53.repository.Route53Repository;
import kr.co.inslab.utils.CommonConstants;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.threeten.bp.LocalDateTime;

import java.util.List;

@Component
public class Route53ProjectEventListener implements ApplicationListener<ProjectEvent> {

    private final Logger log = LoggerFactory.getLogger(Route53ProjectEventListener.class);

    private final Route53 route53;

    private final Route53Repository route53Repository;

    public Route53ProjectEventListener(Route53 route53, Route53Repository route53Repository) {
        this.route53 = route53;
        this.route53Repository = route53Repository;
    }

    @SneakyThrows
    @Override
    public void onApplicationEvent(ProjectEvent event) {
        String eventType = event.getEventType();

        switch (eventType){
            case CommonConstants.CREATE:
                  Route53Info route53Info = this.startCreating(event);
                  this.createZone(route53Info);
                  this.createRecord(route53Info);
                break;
            case CommonConstants.DELETE:
                Route53Info delRoute53Info = this.startDeleting(event);
                delRoute53Info = this.deleteZone(delRoute53Info);
                this.deleteRecord(delRoute53Info);
                break;
            default:
                break;
        }
    }

    private Route53Info startDeleting(ProjectEvent event){
        this.route53Repository.findKRoute53InfoByGantryProjectId(event.getGantryProjectId());
        Route53Info route53Info = this.route53Repository.findKRoute53InfoByGantryProjectId(event.getGantryProjectId());
        route53Info.getRecord().setStatus(CommonConstants.DELETING);
        route53Info.getZone().setStatus(CommonConstants.DELETING);
        return this.route53Repository.save(route53Info);
    }

    private Route53Info deleteZone(Route53Info route53Info) throws Route53Exception {
        this.route53.deleteZone(route53Info.getZone().getName());
        route53Info.getZone().setStatus(CommonConstants.DELETED);
        return this.route53Repository.save(route53Info);
    }

    private void deleteRecord(Route53Info route53Info) throws Route53Exception{
        this.route53.deleteRecord(CommonConstants.GANTRY_DOT_AI_DOT,route53Info.getRecord().getName(),route53Info.getRecord().getType());
        route53Info.getRecord().setStatus(CommonConstants.DELETED);
        this.route53Repository.save(route53Info);
    }

    private Route53Info startCreating(ProjectEvent event) {
        String gantryProjectId = event.getGantryProjectId();
        String gantryProjectName= event.getGantryProjectName();
        String zoneName = gantryProjectName + CommonConstants.DOT_GANTRY_DOT_AI_DOT;
        String recordName = gantryProjectName + CommonConstants.DOT_GANTRY_DOT_AI_DOT;

        GantryInfo gantryInfo = new GantryInfo();
        gantryInfo.setProjectId(gantryProjectId);

        Zone zone = new Zone();
        zone.setName(zoneName);
        zone.setStatus(CommonConstants.CREATING);

        Record record = new Record();
        record.setName(recordName);
        record.setStatus(CommonConstants.CREATING);

        Route53Info route53Info = new Route53Info();
        route53Info.setGantry(gantryInfo);
        route53Info.setZone(zone);
        route53Info.setRecord(record);

        return this.route53Repository.save(route53Info);
    }

    private void createZone(Route53Info route53Info) throws Route53Exception {

        Zone zone = route53Info.getZone();
        Zone resZone = this.route53.createZone(route53Info.getZone().getName());

        zone.setZoneId(resZone.getZoneId());
        zone.setCreatedAt(LocalDateTime.now());
        zone.setStatus(CommonConstants.CREATED);

        route53Info.setZone(zone);

        this.route53Repository.save(route53Info);
    }

    private void createRecord(Route53Info route53Info) throws Route53Exception {

        List<Record> records = this.route53.getRecords(route53Info.getZone().getName());

        for(Record record : records){
            if(record.getType().equals(CommonConstants.NS)){
                record.setTtl((long)300);
                this.route53.createRecord(CommonConstants.GANTRY_DOT_AI_DOT,record);
                record.setStatus(CommonConstants.CREATED);
                record.setCreatedAt(LocalDateTime.now());
                route53Info.setRecord(record);
                this.route53Repository.save(route53Info);
                break;
            }
        }
    }
}
