package kr.co.inslab.harbor;

import kr.co.inslab.auth.OAuthToken;
import kr.co.inslab.harbor.model.HarborProject;
import kr.co.inslab.harbor.model.HarborProjectMetadata;
import kr.co.inslab.harbor.model.NewHarborProject;
import kr.co.inslab.model.Token;
import kr.co.inslab.utils.CommonConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class HarborService implements Harbor {

    private final Logger log = LoggerFactory.getLogger(HarborService.class);

    private final RestTemplate restTemplate;

    private final OAuthToken oAuthToken;

    private final RedisTemplate<String,Object> redisTemplate;

    @Value("${harbor.api.endpoint}")
    private String HARBOR_API_ENDPOINT;

    @Value("${admin.id}")
    private String ADMIN_ID;

    @Value("${admin.password}")
    private String ADMIN_PASSWORD;


    public HarborService(RestTemplate restTemplate, OAuthToken oAuthToken, RedisTemplate<String, Object> redisTemplate) {
        this.restTemplate = restTemplate;
        this.redisTemplate = redisTemplate;
        this.oAuthToken = oAuthToken;
    }

    @Override
    public ResponseEntity<Void> createProject(String projectName) throws HarborException {

        //get idToken
        String idToken = this.getIdToken();

        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER_ + idToken);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));

        //get default project
        NewHarborProject newHarborProject = this.getDefaultHarborProject(projectName);

        //send request
        HttpEntity<NewHarborProject> httpEntity = new HttpEntity<>(newHarborProject,httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.postForEntity(HARBOR_API_ENDPOINT+"/projects",httpEntity,Void.class);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new HarborException(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @Override
    public List<HarborProject> getProjectByName(String projectName) throws HarborException {
        //get idToken
        String idToken = this.getIdToken();
        log.debug("idToken:"+idToken);
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER_ + idToken);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));


        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<HarborProject>> responseEntity =
                this.restTemplate.exchange(HARBOR_API_ENDPOINT+"/projects?name={name}",HttpMethod.GET,httpEntity, new ParameterizedTypeReference<List<HarborProject>>() {},projectName);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new HarborException(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<Void> deleteProject(int projectId) throws HarborException {
        String idToken = this.getIdToken();
        //set header
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add(HttpHeaders.AUTHORIZATION, CommonConstants.BEARER_ + idToken);

        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<Void> responseEntity = this.restTemplate.exchange(HARBOR_API_ENDPOINT+"/projects/{projectId}",HttpMethod.DELETE,httpEntity,Void.class,projectId);
        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new HarborException(responseEntity.getStatusCode().getReasonPhrase(),responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    private NewHarborProject getDefaultHarborProject(String projectName){
        //harbor project metadata
        HarborProjectMetadata harborProjectMetadata = new HarborProjectMetadata();
        harborProjectMetadata.setPublic("false");
        harborProjectMetadata.setEnableContentTrust("false");
        harborProjectMetadata.setPreventVul("false");
        harborProjectMetadata.setSeverity("low");
        harborProjectMetadata.autoScan("false");
        harborProjectMetadata.setReuseSysCveWhitelist("true");

        //harbor project
        NewHarborProject newHarborProject = new NewHarborProject();
        newHarborProject.setProjectName(projectName);
        newHarborProject.metadata(harborProjectMetadata) ;
        newHarborProject.cveWhitelist(null);
        return newHarborProject;
    }

    //redis에서 조회 후 없으면 토큰을 새로 받는다.
    private String getIdToken(){
        String idToken = null;

        ValueOperations<String,Object> savedValueOperations = redisTemplate.opsForValue();

        @SuppressWarnings("unchecked")
        HashMap<String,String> adminIdToken = (HashMap<String, String>) savedValueOperations.get(CommonConstants.ADMIN_TOKEN);

        //get idToken
        if(adminIdToken != null){
            idToken = adminIdToken.get(CommonConstants.ID_TOKEN);
            return idToken;
        }

        //get new idToken
        Token token = this.oAuthToken.getToken(ADMIN_ID,ADMIN_PASSWORD);
        idToken = token.getIdToken();

        //Save to redis
        ValueOperations<String,Object> newValueOperations = redisTemplate.opsForValue();
        Map<String,String> idTokenInfo = new HashMap<>();
        idTokenInfo.put(CommonConstants.ID_TOKEN,idToken);
        newValueOperations.set(CommonConstants.ADMIN_TOKEN,idTokenInfo);

        //Set expiration time
        redisTemplate.expire(CommonConstants.ADMIN_TOKEN,Long.parseLong(token.getExpiresIn())-10,TimeUnit.SECONDS);

        return idToken;
    }
}
