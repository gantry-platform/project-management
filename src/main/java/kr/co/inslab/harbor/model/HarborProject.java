package kr.co.inslab.harbor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * HarborProject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T12:48:56.195+09:00[Asia/Seoul]")
public class HarborProject   {
  @JsonProperty("project_id")
  private Integer projectId = null;

  @JsonProperty("owner_id")
  private Integer ownerId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("creation_time")
  private String creationTime = null;

  @JsonProperty("update_time")
  private String updateTime = null;

  @JsonProperty("deleted")
  private Boolean deleted = null;

  @JsonProperty("owner_name")
  private String ownerName = null;

  @JsonProperty("togglable")
  private Boolean togglable = null;

  @JsonProperty("current_user_role_id")
  private Integer currentUserRoleId = null;

  @JsonProperty("repo_count")
  private Integer repoCount = null;

  @JsonProperty("chart_count")
  private Integer chartCount = null;

  @JsonProperty("metadata")
  private HarborProjectMetadata metadata = null;

  @JsonProperty("cve_whitelist")
  private CVEWhitelist cveWhitelist = null;

  public HarborProject projectId(Integer projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Project ID
   * @return projectId
  **/
  @ApiModelProperty(value = "Project ID")
  
    public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public HarborProject ownerId(Integer ownerId) {
    this.ownerId = ownerId;
    return this;
  }

  /**
   * The owner ID of the project always means the creator of the project.
   * @return ownerId
  **/
  @ApiModelProperty(value = "The owner ID of the project always means the creator of the project.")
  
    public Integer getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(Integer ownerId) {
    this.ownerId = ownerId;
  }

  public HarborProject name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the project.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the project.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HarborProject creationTime(String creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * The creation time of the project.
   * @return creationTime
  **/
  @ApiModelProperty(value = "The creation time of the project.")
  
    public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public HarborProject updateTime(String updateTime) {
    this.updateTime = updateTime;
    return this;
  }

  /**
   * The update time of the project.
   * @return updateTime
  **/
  @ApiModelProperty(value = "The update time of the project.")
  
    public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }

  public HarborProject deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * A deletion mark of the project.
   * @return deleted
  **/
  @ApiModelProperty(value = "A deletion mark of the project.")
  
    public Boolean isDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public HarborProject ownerName(String ownerName) {
    this.ownerName = ownerName;
    return this;
  }

  /**
   * The owner name of the project.
   * @return ownerName
  **/
  @ApiModelProperty(value = "The owner name of the project.")
  
    public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public HarborProject togglable(Boolean togglable) {
    this.togglable = togglable;
    return this;
  }

  /**
   * Correspond to the UI about whether the project's publicity is  updatable (for UI)
   * @return togglable
  **/
  @ApiModelProperty(value = "Correspond to the UI about whether the project's publicity is  updatable (for UI)")
  
    public Boolean isTogglable() {
    return togglable;
  }

  public void setTogglable(Boolean togglable) {
    this.togglable = togglable;
  }

  public HarborProject currentUserRoleId(Integer currentUserRoleId) {
    this.currentUserRoleId = currentUserRoleId;
    return this;
  }

  /**
   * The role ID of the current user who triggered the API (for UI)
   * @return currentUserRoleId
  **/
  @ApiModelProperty(value = "The role ID of the current user who triggered the API (for UI)")
  
    public Integer getCurrentUserRoleId() {
    return currentUserRoleId;
  }

  public void setCurrentUserRoleId(Integer currentUserRoleId) {
    this.currentUserRoleId = currentUserRoleId;
  }

  public HarborProject repoCount(Integer repoCount) {
    this.repoCount = repoCount;
    return this;
  }

  /**
   * The number of the repositories under this project.
   * @return repoCount
  **/
  @ApiModelProperty(value = "The number of the repositories under this project.")
  
    public Integer getRepoCount() {
    return repoCount;
  }

  public void setRepoCount(Integer repoCount) {
    this.repoCount = repoCount;
  }

  public HarborProject chartCount(Integer chartCount) {
    this.chartCount = chartCount;
    return this;
  }

  /**
   * The total number of charts under this project.
   * @return chartCount
  **/
  @ApiModelProperty(value = "The total number of charts under this project.")
  
    public Integer getChartCount() {
    return chartCount;
  }

  public void setChartCount(Integer chartCount) {
    this.chartCount = chartCount;
  }

  public HarborProject metadata(HarborProjectMetadata metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public HarborProjectMetadata getMetadata() {
    return metadata;
  }

  public void setMetadata(HarborProjectMetadata metadata) {
    this.metadata = metadata;
  }

  public HarborProject cveWhitelist(CVEWhitelist cveWhitelist) {
    this.cveWhitelist = cveWhitelist;
    return this;
  }

  /**
   * Get cveWhitelist
   * @return cveWhitelist
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public CVEWhitelist getCveWhitelist() {
    return cveWhitelist;
  }

  public void setCveWhitelist(CVEWhitelist cveWhitelist) {
    this.cveWhitelist = cveWhitelist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HarborProject harborProject = (HarborProject) o;
    return Objects.equals(this.projectId, harborProject.projectId) &&
        Objects.equals(this.ownerId, harborProject.ownerId) &&
        Objects.equals(this.name, harborProject.name) &&
        Objects.equals(this.creationTime, harborProject.creationTime) &&
        Objects.equals(this.updateTime, harborProject.updateTime) &&
        Objects.equals(this.deleted, harborProject.deleted) &&
        Objects.equals(this.ownerName, harborProject.ownerName) &&
        Objects.equals(this.togglable, harborProject.togglable) &&
        Objects.equals(this.currentUserRoleId, harborProject.currentUserRoleId) &&
        Objects.equals(this.repoCount, harborProject.repoCount) &&
        Objects.equals(this.chartCount, harborProject.chartCount) &&
        Objects.equals(this.metadata, harborProject.metadata) &&
        Objects.equals(this.cveWhitelist, harborProject.cveWhitelist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, ownerId, name, creationTime, updateTime, deleted, ownerName, togglable, currentUserRoleId, repoCount, chartCount, metadata, cveWhitelist);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HarborProject {\n");
    
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    ownerId: ").append(toIndentedString(ownerId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
    sb.append("    togglable: ").append(toIndentedString(togglable)).append("\n");
    sb.append("    currentUserRoleId: ").append(toIndentedString(currentUserRoleId)).append("\n");
    sb.append("    repoCount: ").append(toIndentedString(repoCount)).append("\n");
    sb.append("    chartCount: ").append(toIndentedString(chartCount)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    cveWhitelist: ").append(toIndentedString(cveWhitelist)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
