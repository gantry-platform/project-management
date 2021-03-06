package kr.co.inslab.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.inslab.gantry.GantryProject;
import kr.co.inslab.gantry.GantryUser;
import kr.co.inslab.harbor.Harbor;
import kr.co.inslab.harbor.model.HarborProject;
import kr.co.inslab.kubernetes.Kubernetes;
import kr.co.inslab.kubernetes.model.Namespace;
import kr.co.inslab.model.*;
import kr.co.inslab.route53.Route53;
import kr.co.inslab.route53.Route53Exception;
import kr.co.inslab.route53.model.Zone;
import kr.co.inslab.utils.CommonConstants;
import org.keycloak.TokenVerifier;
import org.keycloak.representations.AccessToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-16T10:39:54.886+09:00[Asia/Seoul]")
@Controller
public class ProjectsApiController implements ProjectsApi {

    private static final Logger log = LoggerFactory.getLogger(ProjectsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final GantryProject gantryProject;

    private final GantryUser gantryUser;

    private final Harbor harbor;

    private final Kubernetes kubernetes;

    private final Route53 route53;

    @Value("${dashboard.url}")
    private String dashboardUrl;

    @org.springframework.beans.factory.annotation.Autowired
    public ProjectsApiController(ObjectMapper objectMapper, HttpServletRequest request, GantryProject gantryProject, GantryUser gantryUser, Harbor harbor, Kubernetes kubernetes, Route53 route53) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.gantryProject = gantryProject;
        this.gantryUser = gantryUser;
        this.harbor = harbor;
        this.kubernetes = kubernetes;
        this.route53 = route53;
    }

    //TODO: interceptor나 adviser로변경
    private void checkResource(String userId,String projectId) throws Exception {
        gantryUser.checkUserById(userId);
        gantryProject.checkProjectByProjectId(projectId);
    }

    @Override
    public ResponseEntity<List<Project>> projectsGet() throws Exception {
        //임시코드
        String userId = this.getUserId(request);
        gantryUser.checkUserById(userId);
        List<Project> projects =  this.gantryProject.getProjects(userId);
        return new ResponseEntity<List<Project>>(projects,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> projectsPost(NewProject body) throws Exception{

        //임시코드
        String userId = this.getUserId(request);
        gantryUser.checkUserById(userId);

        String proejectName = body.getName();
        String description = body.getDescription();

        //check harbor projectName
        List<HarborProject> harborProjects = this.harbor.getProjectByName(proejectName);
        if(harborProjects != null){
            throw new ApiException("Exists Harbor Project:"+proejectName,HttpStatus.CONFLICT);
        }

        //check kubernetes namespace
      List<Namespace> namespaces = this.kubernetes.getNamespaces();
        if(namespaces != null){
            for(Namespace namespace : namespaces){
                if(namespace.getMetadata().getName().equals(proejectName)){
                    throw new ApiException("Exists Kubernetes Namespace:"+proejectName,HttpStatus.CONFLICT);
                }
            }
        }

        //check Route53 zone
        try {
            Zone zone = this.route53.getZones(proejectName+CommonConstants.DOT_GANTRY_DOT_AI_DOT);
            if(zone != null){
                throw new ApiException("Exists Zone Name:"+proejectName,HttpStatus.CONFLICT);
            }
        } catch (HttpClientErrorException.NotFound ex){
            log.info("Not Found Zone Name");
        }

        Project project = gantryProject.createProject(userId,proejectName,description);

        ResponseEntity<kr.co.inslab.model.Project> res = new ResponseEntity<kr.co.inslab.model.Project>(project,HttpStatus.OK);

        return res;
    }


    @Override
    public String confirmJoin(WebRequest request,String token, String email) throws Exception {
        boolean success = false;
        try{
            success = gantryProject.joinNewProjectAndGroupForExistsUser(token, email);
        }catch (Exception ex){
            log.error(ex.toString());
            success = false;
        }

        if(success == false){
            return "intive-failure";
        }
        return "redirect:"+dashboardUrl;
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdActivePut(String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);
        this.checkResource(userId,projectId);

        Map<String,String> attrs = new HashMap<String, String>();
        attrs.put(CommonConstants.STATUS, kr.co.inslab.model.Project.StatusEnum.ACTIVE.toString());

        gantryProject.updateProjectInfo(projectId,attrs);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdArchivePut(String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        Map<String,String> attrs = new HashMap<String, String>();

        attrs.put(CommonConstants.STATUS, kr.co.inslab.model.Project.StatusEnum.ARCHIVE.toString());

        gantryProject.updateProjectInfo(projectId,attrs);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdDelete(String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        if(!gantryProject.isOwnerOfProject(userId,projectId)){
            throw new ApiException(userId+"is not the owner of project",HttpStatus.BAD_REQUEST);
        }

        gantryProject.deleteProjectById(projectId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> projectsProjectIdGet(String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        Boolean existsUserInProject = gantryProject.existsUserInProject(userId,projectId);

        if(!existsUserInProject){
            throw new ApiException("Does Not Exists User In Project",HttpStatus.BAD_REQUEST);
        }

        Project project = gantryProject.getProjectById(projectId);

        return new ResponseEntity<kr.co.inslab.model.Project>(project,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Group>> projectsProjectIdGroupsGet(String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        List<Group> groups = gantryProject.getGroupsByProjectId(projectId);

        return  new ResponseEntity<List<Group>>(groups,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdGroupsGroupIdInvitationPut(String projectId, String groupId, @NotNull @Valid String email) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);
        gantryProject.inviteUserToGroup(email,projectId,groupId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdGroupsInvitationDelete(String projectId, @NotNull @Valid String email) throws Exception {

        this.getUserId(request);
        gantryProject.deleteMemberInPending(projectId,email);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Member>> projectsProjectIdGroupsGroupIdMembersGet(String projectId, String groupId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        ResponseEntity<List<Member>> res = null;
        this.checkResource(userId,projectId);
        List<Member> members = gantryProject.getSubGroupMember(projectId,groupId);

        return new ResponseEntity<List<Member>>(members,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdGroupsGroupIdMembersPatch(String projectId, String groupId, @NotNull @Valid String memberId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        if(!gantryProject.isAdminOfProject(userId,projectId)){
            throw new ApiException(userId+"is not the admin of the project",HttpStatus.BAD_REQUEST);
        }

        gantryProject.moveGroupOfMember(projectId,groupId,memberId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> projectsProjectIdMembersMemberIdDelete(String projectId, String memberId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        this.checkResource(userId,projectId);

        if(!gantryProject.isAdminOfProject(userId,projectId)){
            throw new ApiException(userId+"is not the admin of the project",HttpStatus.BAD_REQUEST);
        }

        gantryProject.deleteMemberInProject(projectId,memberId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Void> projectsProjectIdPatch(@Valid UpdateProject body,String projectId) throws Exception {

        //임시코드
        String userId = this.getUserId(request);

        Map<String,String> attrs = null;
        String owner = body.getOwner();
        String description = body.getDescription();

        this.checkResource(userId,projectId);

        if(!gantryProject.isOwnerOfProject(userId,projectId)){
            throw new ApiException(userId+"is not the owner of project",HttpStatus.BAD_REQUEST);
        }


        attrs = new HashMap<String, String>();

        if(owner!=null && !owner.isEmpty()){
            attrs.put(CommonConstants.OWNER,owner);
        }
        if(description!=null && !description.isEmpty()){
            attrs.put(CommonConstants.DESCRIPTION,description);
        }


        gantryProject.updateProjectInfo(projectId,attrs);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    //임시코드
    private final String getUserId(HttpServletRequest request) throws Exception {
        String userId = null;
        String token = request.getHeader("Authorization");
        if (token != null && !token.isEmpty()) {
            String[] splitToken = token.split(" ");
            AccessToken accessToken = TokenVerifier.create(splitToken[1], AccessToken.class).getToken();
            userId = accessToken.getSubject();
            log.debug("subject:"+userId);
        }
        if(userId==null){
            throw new ApiException("Invaild userId", HttpStatus.BAD_REQUEST);
        }
        return userId;
    }
}
