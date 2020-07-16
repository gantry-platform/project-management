package kr.co.inslab.gantry;


import kr.co.inslab.keycloak.KeyCloakAdminException;
import kr.co.inslab.keycloak.AbstractKeyCloak;
import org.keycloak.admin.client.Keycloak;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GantryUserService extends AbstractKeyCloak implements GantryUser {

    private final Logger logger = LoggerFactory.getLogger(GantryUserService.class);

    public GantryUserService(Keycloak keycloakAdmin) {
        super(keycloakAdmin);
    }

    @Override
    public void checkUserById(String userId) throws UserException {
        try{
            super.checkUserById(userId);
        }catch (KeyCloakAdminException e){
            throw new UserException(e.getMessage(),e.getHttpStatus());
        }
    }
}
