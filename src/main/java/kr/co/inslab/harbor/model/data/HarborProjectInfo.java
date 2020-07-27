package kr.co.inslab.harbor.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import kr.co.inslab.gantry.data.GantryInfo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * HarborProjectInfo
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-27T13:31:31.244+09:00[Asia/Seoul]")
@Document(collection = "harbor")
public class HarborProjectInfo   {
  @JsonProperty("id")
  @Id
  private String id = null;

  @JsonProperty("gantry")
  private GantryInfo gantry = null;

  @JsonProperty("harbor")
  private HarborProjectInfoHarbor harbor = null;

  public HarborProjectInfo id(String id) {
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

  public HarborProjectInfo gantry(GantryInfo gantry) {
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

  public HarborProjectInfo harbor(HarborProjectInfoHarbor harbor) {
    this.harbor = harbor;
    return this;
  }

  /**
   * Get harbor
   * @return harbor
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public HarborProjectInfoHarbor getHarbor() {
    return harbor;
  }

  public void setHarbor(HarborProjectInfoHarbor harbor) {
    this.harbor = harbor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HarborProjectInfo harborProjectInfo = (HarborProjectInfo) o;
    return Objects.equals(this.id, harborProjectInfo.id) &&
        Objects.equals(this.gantry, harborProjectInfo.gantry) &&
        Objects.equals(this.harbor, harborProjectInfo.harbor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gantry, harbor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HarborProjectInfo {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    gantry: ").append(toIndentedString(gantry)).append("\n");
    sb.append("    harbor: ").append(toIndentedString(harbor)).append("\n");
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
