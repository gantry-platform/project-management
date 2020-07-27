package kr.co.inslab.harbor;

import kr.co.inslab.harbor.model.data.HarborProjectInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HarborRepository extends MongoRepository<HarborProjectInfo, String> {
    HarborProjectInfo findHarborProjectInfoByGantryProjectId(String gantryProjectId);
}