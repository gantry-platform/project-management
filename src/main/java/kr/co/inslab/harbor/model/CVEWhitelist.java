package kr.co.inslab.harbor.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * The CVE Whitelist for system or project
 */
@ApiModel(description = "The CVE Whitelist for system or project")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T12:48:56.195+09:00[Asia/Seoul]")
public class CVEWhitelist   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("project_id")
  private Integer projectId = null;

  @JsonProperty("expires_at")
  private Integer expiresAt = null;

  @JsonProperty("items")
  @Valid
  private List<CVEWhitelistItem> items = null;

  public CVEWhitelist id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * ID of the whitelist
   * @return id
  **/
  @ApiModelProperty(value = "ID of the whitelist")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CVEWhitelist projectId(Integer projectId) {
    this.projectId = projectId;
    return this;
  }

  /**
   * ID of the project which the whitelist belongs to.  For system level whitelist this attribute is zero.
   * @return projectId
  **/
  @ApiModelProperty(value = "ID of the project which the whitelist belongs to.  For system level whitelist this attribute is zero.")
  
    public Integer getProjectId() {
    return projectId;
  }

  public void setProjectId(Integer projectId) {
    this.projectId = projectId;
  }

  public CVEWhitelist expiresAt(Integer expiresAt) {
    this.expiresAt = expiresAt;
    return this;
  }

  /**
   * the time for expiration of the whitelist, in the form of seconds since epoch.  This is an optional attribute, if it's not set the CVE whitelist does not expire.
   * @return expiresAt
  **/
  @ApiModelProperty(value = "the time for expiration of the whitelist, in the form of seconds since epoch.  This is an optional attribute, if it's not set the CVE whitelist does not expire.")
  
    public Integer getExpiresAt() {
    return expiresAt;
  }

  public void setExpiresAt(Integer expiresAt) {
    this.expiresAt = expiresAt;
  }

  public CVEWhitelist items(List<CVEWhitelistItem> items) {
    this.items = items;
    return this;
  }

  public CVEWhitelist addItemsItem(CVEWhitelistItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<CVEWhitelistItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<CVEWhitelistItem> getItems() {
    return items;
  }

  public void setItems(List<CVEWhitelistItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVEWhitelist cvEWhitelist = (CVEWhitelist) o;
    return Objects.equals(this.id, cvEWhitelist.id) &&
        Objects.equals(this.projectId, cvEWhitelist.projectId) &&
        Objects.equals(this.expiresAt, cvEWhitelist.expiresAt) &&
        Objects.equals(this.items, cvEWhitelist.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, projectId, expiresAt, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVEWhitelist {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
