package kr.co.inslab.route53.repository;


import kr.co.inslab.route53.model.data.Route53Info;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Route53Repository extends MongoRepository<Route53Info, String> {
    Route53Info findKRoute53InfoByGantryProjectId(String gantryProjectId);
}