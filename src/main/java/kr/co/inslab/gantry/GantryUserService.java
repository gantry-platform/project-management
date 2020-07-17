package kr.co.inslab.gantry;


import kr.co.inslab.keycloak.KeyCloakAdminException;
import kr.co.inslab.keycloak.AbstractKeyCloak;
import kr.co.inslab.model.NewUser;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GantryUserService extends AbstractKeyCloak implements GantryUser {

    private final Logger logger = LoggerFactory.getLogger(GantryUserService.class);

    public GantryUserService(Keycloak keycloakAdmin) {
        super(keycloakAdmin);
    }

    @Override
    public void checkUserById(String userId) throws UserException{
        try{
            super.checkUserResource(userId);
        }catch (KeyCloakAdminException e){
            throw new UserException(e.getMessage(),e.getHttpStatus());
        }
    }

    @Override
    public void deleteUser(String userId){
        super.removeUser(userId);
    }

    @Override
    public void createTestUser(NewUser newUser){
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEmailVerified(true);
        userRepresentation.setEnabled(true);
        userRepresentation.setEmail(newUser.getEmail());
        userRepresentation.setUsername(newUser.getUserName());

        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(newUser.getPassword());
        credential.setTemporary(false);

        List<CredentialRepresentation> credentialRepresentations = new ArrayList<>();
        credentialRepresentations.add(credential);
        userRepresentation.setCredentials(credentialRepresentations);
        super.createUser(userRepresentation);
    }
}
