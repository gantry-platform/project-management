package kr.co.inslab.harbor.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * The item in CVE whitelist
 */
@ApiModel(description = "The item in CVE whitelist")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T12:48:56.195+09:00[Asia/Seoul]")
public class CVEWhitelistItem   {
  @JsonProperty("cve_id")
  private String cveId = null;

  public CVEWhitelistItem cveId(String cveId) {
    this.cveId = cveId;
    return this;
  }

  /**
   * The ID of the CVE, such as \"CVE-2019-10164\"
   * @return cveId
  **/
  @ApiModelProperty(value = "The ID of the CVE, such as \"CVE-2019-10164\"")
  
    public String getCveId() {
    return cveId;
  }

  public void setCveId(String cveId) {
    this.cveId = cveId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CVEWhitelistItem cvEWhitelistItem = (CVEWhitelistItem) o;
    return Objects.equals(this.cveId, cvEWhitelistItem.cveId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cveId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CVEWhitelistItem {\n");
    
    sb.append("    cveId: ").append(toIndentedString(cveId)).append("\n");
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
