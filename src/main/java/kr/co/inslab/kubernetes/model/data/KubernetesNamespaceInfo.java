package kr.co.inslab.kubernetes.model.data;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import kr.co.inslab.gantry.data.GantryInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;


/**
 * KubernetsNamespaceInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-27T13:31:31.244+09:00[Asia/Seoul]")
@Document(collection = "kubernetes")
public class KubernetesNamespaceInfo {
  @JsonProperty("id")
  @Id
  private String id = null;

  @JsonProperty("gantry")
  private GantryInfo gantry = null;

  @JsonProperty("kubernetes")
  private KubernetesNamespaceInfoKubernetes kubernetes = null;

  public KubernetesNamespaceInfo id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public KubernetesNamespaceInfo gantry(GantryInfo gantry) {
    this.gantry = gantry;
    return this;
  }

  /**
   * Get gantry
   * @return gantry
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public GantryInfo getGantry() {
    return gantry;
  }

  public void setGantry(GantryInfo gantry) {
    this.gantry = gantry;
  }

  public KubernetesNamespaceInfo kubernetes(KubernetesNamespaceInfoKubernetes kubernetes) {
    this.kubernetes = kubernetes;
    return this;
  }

  /**
   * Get kubernetes
   * @return kubernetes
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public KubernetesNamespaceInfoKubernetes getKubernetes() {
    return kubernetes;
  }

  public void setKubernetes(KubernetesNamespaceInfoKubernetes kubernetes) {
    this.kubernetes = kubernetes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    KubernetesNamespaceInfo kubernetesNamespaceInfo = (KubernetesNamespaceInfo) o;
    return Objects.equals(this.id, kubernetesNamespaceInfo.id) &&
        Objects.equals(this.gantry, kubernetesNamespaceInfo.gantry) &&
        Objects.equals(this.kubernetes, kubernetesNamespaceInfo.kubernetes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gantry, kubernetes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class KubernetsNamespaceInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    gantry: ").append(toIndentedString(gantry)).append("\n");
    sb.append("    kubernetes: ").append(toIndentedString(kubernetes)).append("\n");
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
