package kr.co.inslab.route53;

import kr.co.inslab.route53.model.Record;
import kr.co.inslab.route53.model.Zone;

import java.util.List;

public interface Route53 {
    Zone getZones(String zoneName) throws Route53Exception;
    Zone createZone(String zoneName) throws Route53Exception;
    void deleteZone(String zoneName) throws Route53Exception;
    Record createRecord(String zoneName,Record record) throws Route53Exception;
    List<Record> getRecords(String zoneName) throws Route53Exception;
    void deleteRecord(String zoneName,String recordName,String type) throws Route53Exception;

}
