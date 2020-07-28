package kr.co.inslab.kubernetes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Namespace
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-28T14:39:40.012+09:00[Asia/Seoul]")
public class Namespace   {
  @JsonProperty("metadata")
  private NamespaceMeta metadata = null;

  @JsonProperty("status")
  private NamespaceStatus status = null;

  public Namespace metadata(NamespaceMeta metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public NamespaceMeta getMetadata() {
    return metadata;
  }

  public void setMetadata(NamespaceMeta metadata) {
    this.metadata = metadata;
  }

  public Namespace status(NamespaceStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public NamespaceStatus getStatus() {
    return status;
  }

  public void setStatus(NamespaceStatus status) {
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
    Namespace namespace = (Namespace) o;
    return Objects.equals(this.metadata, namespace.metadata) &&
        Objects.equals(this.status, namespace.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(metadata, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Namespace {\n");
    
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
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
