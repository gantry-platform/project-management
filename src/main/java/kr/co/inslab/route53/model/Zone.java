package kr.co.inslab.route53.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Zone
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T17:19:06.368+09:00[Asia/Seoul]")
public class Zone   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("zoneId")
  private String zoneId = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("created_at")
  private LocalDateTime createdAt = null;

  @JsonProperty("deleted_at")
  private LocalDateTime deletedAt = null;

  public Zone name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Zone zoneId(String zoneId) {
    this.zoneId = zoneId;
    return this;
  }

  /**
   * Get zoneId
   * @return zoneId
  **/
  @ApiModelProperty(value = "")
  
    public String getZoneId() {
    return zoneId;
  }

  public void setZoneId(String zoneId) {
    this.zoneId = zoneId;
  }

  public Zone status(String status) {
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

  public Zone createdAt(LocalDateTime createdAt) {
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

  public Zone deletedAt(LocalDateTime deletedAt) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Zone zone = (Zone) o;
    return Objects.equals(this.name, zone.name) &&
        Objects.equals(this.zoneId, zone.zoneId) &&
        Objects.equals(this.status, zone.status) &&
        Objects.equals(this.createdAt, zone.createdAt) &&
        Objects.equals(this.deletedAt, zone.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, zoneId, status, createdAt, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Zone {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    zoneId: ").append(toIndentedString(zoneId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    deletedAt: ").append(toIndentedString(deletedAt)).append("\n");
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
