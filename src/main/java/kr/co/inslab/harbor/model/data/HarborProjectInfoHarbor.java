package kr.co.inslab.harbor.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * HarborProjectInfoHarbor
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-27T13:31:31.244+09:00[Asia/Seoul]")
public class HarborProjectInfoHarbor   {
  @JsonProperty("project_id")
  private String projectId = null;

  @JsonProperty("project_name")
  private String projectName = null;

  @JsonProperty("created_at")
  private LocalDateTime createdAt = null;

  @JsonProperty("deleted_at")
  private LocalDateTime deletedAt = null;

  @JsonProperty("status")
  private String status = null;

  public HarborProjectInfoHarbor projectId(String projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * Get projectId
   * @return projectId
  **/
  @ApiModelProperty(value = "")
  
    public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public HarborProjectInfoHarbor projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * Get projectName
   * @return projectName
  **/
  @ApiModelProperty(value = "")
  
    public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public HarborProjectInfoHarbor createdAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public HarborProjectInfoHarbor deletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
    return this;
  }

  /**
   * Get deletedAt
   * @return deletedAt
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public LocalDateTime getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(LocalDateTime deletedAt) {
    this.deletedAt = deletedAt;
  }

  public HarborProjectInfoHarbor status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  
    public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HarborProjectInfoHarbor harborProjectInfoHarbor = (HarborProjectInfoHarbor) o;
    return Objects.equals(this.projectId, harborProjectInfoHarbor.projectId) &&
        Objects.equals(this.projectName, harborProjectInfoHarbor.projectName) &&
        Objects.equals(this.createdAt, harborProjectInfoHarbor.createdAt) &&
        Objects.equals(this.deletedAt, harborProjectInfoHarbor.deletedAt) &&
        Objects.equals(this.status, harborProjectInfoHarbor.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectId, projectName, createdAt, deletedAt, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HarborProjectInfoHarbor {\n");
    
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
