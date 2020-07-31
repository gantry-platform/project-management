package kr.co.inslab.route53;

import kr.co.inslab.harbor.HarborException;
import kr.co.inslab.route53.model.Record;
import kr.co.inslab.route53.model.Zone;
import kr.co.inslab.utils.CommonConstants;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Route53Service implements Route53{


    private final Logger log = LoggerFactory.getLogger(Route53Service.class);

    private final RestTemplate restTemplate;

    @Value("${route53.api.endpoint}")
    private String ROUTE53_API_ENDPOINT;

    public Route53Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Zone getZones(String zoneName) throws Route53Exception {

        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<Zone> responseEntity
                = this.restTemplate.exchange(ROUTE53_API_ENDPOINT+"/zones/{zoneName}", HttpMethod.GET,httpEntity,new ParameterizedTypeReference<Zone>(){},zoneName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

    @Override
    public Zone createZone(String zoneName) throws Route53Exception {

        //임시코드
        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Zone> responseEntity =
                this.restTemplate.exchange(ROUTE53_API_ENDPOINT+"/zones/{zoneName}",HttpMethod.POST,httpEntity,new ParameterizedTypeReference<Zone>(){},zoneName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

    @Override
    public Record createRecord(String zoneName, Record record) throws Route53Exception {
        //임시코드
        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Record> httpEntity = new HttpEntity<>(record,httpHeaders);
        ResponseEntity<Record> responseEntity =
                this.restTemplate.exchange(ROUTE53_API_ENDPOINT+"/zones/{zoneName}/records",HttpMethod.POST,httpEntity,new ParameterizedTypeReference<Record>(){},zoneName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }

    @Override
    public List<Record> getRecords(String zoneName) throws Route53Exception {
        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<List<Record>> responseEntity
                = this.restTemplate.exchange(ROUTE53_API_ENDPOINT+"/zones/{zoneName}/records", HttpMethod.GET,httpEntity,new ParameterizedTypeReference<List<Record>>(){},zoneName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }


    @Override
    public void deleteZone(String zoneName) throws Route53Exception {
        //임시코드
        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Void> responseEntity =  this.restTemplate.exchange(ROUTE53_API_ENDPOINT+"/zones/{zoneName}",HttpMethod.DELETE,httpEntity,Void.class,zoneName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
    }

    @Override
    public void deleteRecord(String zoneName, String recordName, String type) throws Route53Exception {
        //임시코드
        String auth = this.getAuth();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.AUTHORIZATION, auth);

        //send request
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.exchange
                (ROUTE53_API_ENDPOINT+"/zones/{zoneName}/records/{record}?type={type}",HttpMethod.DELETE,httpEntity,Void.class,zoneName,recordName,type);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new Route53Exception(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
    }
    //임시코드
    private String getAuth(){
        String auth = "gantry" + ":" + "Gantry1234!";
        byte[] encodedAuth = Base64.encodeBase64(
                auth.getBytes(Charset.forName("US-ASCII")) );
        return "Basic "+ new String(encodedAuth);
    }
}
