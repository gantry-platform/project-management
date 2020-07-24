package kr.co.inslab.harbor.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * NewHarborProject
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T12:48:56.195+09:00[Asia/Seoul]")
public class NewHarborProject   {
  @JsonProperty("project_name")
  private String projectName = null;

  @JsonProperty("metadata")
  private HarborProjectMetadata metadata = null;

  @JsonProperty("cve_whitelist")
  private CVEWhitelist cveWhitelist = null;

  @JsonProperty("count_limit")
  private Long countLimit = null;

  @JsonProperty("storage_limit")
  private Long storageLimit = null;

  public NewHarborProject projectName(String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * The name of the project.
   * @return projectName
  **/
  @ApiModelProperty(value = "The name of the project.")
  
    public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public NewHarborProject metadata(HarborProjectMetadata metadata) {
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

  public NewHarborProject cveWhitelist(CVEWhitelist cveWhitelist) {
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

  public NewHarborProject countLimit(Long countLimit) {
    this.countLimit = countLimit;
    return this;
  }

  /**
   * The count quota of the project.
   * @return countLimit
  **/
  @ApiModelProperty(value = "The count quota of the project.")
  
    public Long getCountLimit() {
    return countLimit;
  }

  public void setCountLimit(Long countLimit) {
    this.countLimit = countLimit;
  }

  public NewHarborProject storageLimit(Long storageLimit) {
    this.storageLimit = storageLimit;
    return this;
  }

  /**
   * The storage quota of the project.
   * @return storageLimit
  **/
  @ApiModelProperty(value = "The storage quota of the project.")
  
    public Long getStorageLimit() {
    return storageLimit;
  }

  public void setStorageLimit(Long storageLimit) {
    this.storageLimit = storageLimit;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewHarborProject newHarborProject = (NewHarborProject) o;
    return Objects.equals(this.projectName, newHarborProject.projectName) &&
        Objects.equals(this.metadata, newHarborProject.metadata) &&
        Objects.equals(this.cveWhitelist, newHarborProject.cveWhitelist) &&
        Objects.equals(this.countLimit, newHarborProject.countLimit) &&
        Objects.equals(this.storageLimit, newHarborProject.storageLimit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectName, metadata, cveWhitelist, countLimit, storageLimit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewHarborProject {\n");
    
    sb.append("    projectName: ").append(toIndentedString(projectName)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    cveWhitelist: ").append(toIndentedString(cveWhitelist)).append("\n");
    sb.append("    countLimit: ").append(toIndentedString(countLimit)).append("\n");
    sb.append("    storageLimit: ").append(toIndentedString(storageLimit)).append("\n");
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
