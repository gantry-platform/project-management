package kr.co.inslab.kubernetes.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * KubernetsNamespaceInfoKubernetes
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-27T13:31:31.244+09:00[Asia/Seoul]")
public class KubernetesNamespaceInfoKubernetes {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("created_at")
  private LocalDateTime createdAt = null;

  @JsonProperty("deleted_at")
  private LocalDateTime deletedAt = null;

  public KubernetesNamespaceInfoKubernetes name(String name) {
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

  public KubernetesNamespaceInfoKubernetes status(String status) {
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

  public KubernetesNamespaceInfoKubernetes createdAt(LocalDateTime createdAt) {
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

  public KubernetesNamespaceInfoKubernetes deletedAt(LocalDateTime deletedAt) {
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
    KubernetesNamespaceInfoKubernetes kubernetesNamespaceInfoKubernetes = (KubernetesNamespaceInfoKubernetes) o;
    return Objects.equals(this.name, kubernetesNamespaceInfoKubernetes.name) &&
        Objects.equals(this.status, kubernetesNamespaceInfoKubernetes.status) &&
        Objects.equals(this.createdAt, kubernetesNamespaceInfoKubernetes.createdAt) &&
        Objects.equals(this.deletedAt, kubernetesNamespaceInfoKubernetes.deletedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, status, createdAt, deletedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KubernetsNamespaceInfoKubernetes {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
