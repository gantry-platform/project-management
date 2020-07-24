package kr.co.inslab.auth;

import kr.co.inslab.model.Token;
import kr.co.inslab.utils.CommonConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class KeycloakTokenService implements OAuthToken{

    private final RestTemplate restTemplate;

    @Value("${keycloak.targetClientId}")
    private String CLIENT_ID;

    @Value("${keycloak.targetClientSecret}")
    private String CLIENT_SECRET;

    @Value("${keycloak.tokenEndpoint}")
    private String TOKEN_ENDPOINT;

    public KeycloakTokenService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Token getToken(String username, String password){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        MultiValueMap<String,String> formMap = new LinkedMultiValueMap<>();
        formMap.add(CommonConstants.CLIENT_ID,CLIENT_ID);
        formMap.add(CommonConstants.CLIENT_SECRET,CLIENT_SECRET);
        formMap.add(CommonConstants.USERNAME,username);
        formMap.add(CommonConstants.PASSWORD,password);
        formMap.add(CommonConstants.GRANT_TYPE, CommonConstants.PASSWORD);
        formMap.add(CommonConstants.SCOPE,CommonConstants.OPENID);

        HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(formMap,httpHeaders);
        ResponseEntity<Token> res = this.restTemplate.postForEntity(TOKEN_ENDPOINT,httpEntity,Token.class);

        return res.getBody();

    }
}
