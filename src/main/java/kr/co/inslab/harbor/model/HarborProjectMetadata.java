package kr.co.inslab.harbor.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * HarborProjectMetadata
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-22T12:48:56.195+09:00[Asia/Seoul]")
public class HarborProjectMetadata   {
  @JsonProperty("public")
  private String _public = null;

  @JsonProperty("enable_content_trust")
  private String enableContentTrust = null;

  @JsonProperty("prevent_vul")
  private String preventVul = null;

  @JsonProperty("severity")
  private String severity = null;

  @JsonProperty("auto_scan")
  private String autoScan = null;

  @JsonProperty("reuse_sys_cve_whitelist")
  private String reuseSysCveWhitelist = null;

  public HarborProjectMetadata _public(String _public) {
    this._public = _public;
    return this;
  }

  /**
   * The public status of the project. The valid values are \"true\", \"false\".
   * @return _public
  **/
  @ApiModelProperty(value = "The public status of the project. The valid values are \"true\", \"false\".")
  
    public String getPublic() {
    return _public;
  }

  public void setPublic(String _public) {
    this._public = _public;
  }

  public HarborProjectMetadata enableContentTrust(String enableContentTrust) {
    this.enableContentTrust = enableContentTrust;
    return this;
  }

  /**
   * Whether content trust is enabled or not. If it is enabled, user can't pull unsigned images from this project. The valid values are \"true\", \"false\".
   * @return enableContentTrust
  **/
  @ApiModelProperty(value = "Whether content trust is enabled or not. If it is enabled, user can't pull unsigned images from this project. The valid values are \"true\", \"false\".")
  
    public String getEnableContentTrust() {
    return enableContentTrust;
  }

  public void setEnableContentTrust(String enableContentTrust) {
    this.enableContentTrust = enableContentTrust;
  }

  public HarborProjectMetadata preventVul(String preventVul) {
    this.preventVul = preventVul;
    return this;
  }

  /**
   * Whether prevent the vulnerable images from running. The valid values are \"true\", \"false\".
   * @return preventVul
  **/
  @ApiModelProperty(value = "Whether prevent the vulnerable images from running. The valid values are \"true\", \"false\".")
  
    public String getPreventVul() {
    return preventVul;
  }

  public void setPreventVul(String preventVul) {
    this.preventVul = preventVul;
  }

  public HarborProjectMetadata severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * If the vulnerability is high than severity defined here, the images can't be pulled. The valid values are \"negligible\", \"low\", \"medium\", \"high\", \"critical\".
   * @return severity
  **/
  @ApiModelProperty(value = "If the vulnerability is high than severity defined here, the images can't be pulled. The valid values are \"negligible\", \"low\", \"medium\", \"high\", \"critical\".")
  
    public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public HarborProjectMetadata autoScan(String autoScan) {
    this.autoScan = autoScan;
    return this;
  }

  /**
   * Whether scan images automatically when pushing. The valid values are \"true\", \"false\".
   * @return autoScan
  **/
  @ApiModelProperty(value = "Whether scan images automatically when pushing. The valid values are \"true\", \"false\".")
  
    public String getAutoScan() {
    return autoScan;
  }

  public void setAutoScan(String autoScan) {
    this.autoScan = autoScan;
  }

  public HarborProjectMetadata reuseSysCveWhitelist(String reuseSysCveWhitelist) {
    this.reuseSysCveWhitelist = reuseSysCveWhitelist;
    return this;
  }

  /**
   * Whether this project reuse the system level CVE whitelist as the whitelist of its own.  The valid values are \"true\", \"false\". If it is set to \"true\" the actual whitelist associate with this project, if any, will be ignored.
   * @return reuseSysCveWhitelist
  **/
  @ApiModelProperty(value = "Whether this project reuse the system level CVE whitelist as the whitelist of its own.  The valid values are \"true\", \"false\". If it is set to \"true\" the actual whitelist associate with this project, if any, will be ignored.")
  
    public String getReuseSysCveWhitelist() {
    return reuseSysCveWhitelist;
  }

  public void setReuseSysCveWhitelist(String reuseSysCveWhitelist) {
    this.reuseSysCveWhitelist = reuseSysCveWhitelist;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HarborProjectMetadata harborProjectMetadata = (HarborProjectMetadata) o;
    return Objects.equals(this._public, harborProjectMetadata._public) &&
        Objects.equals(this.enableContentTrust, harborProjectMetadata.enableContentTrust) &&
        Objects.equals(this.preventVul, harborProjectMetadata.preventVul) &&
        Objects.equals(this.severity, harborProjectMetadata.severity) &&
        Objects.equals(this.autoScan, harborProjectMetadata.autoScan) &&
        Objects.equals(this.reuseSysCveWhitelist, harborProjectMetadata.reuseSysCveWhitelist);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_public, enableContentTrust, preventVul, severity, autoScan, reuseSysCveWhitelist);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class HarborProjectMetadata {\n");
    
    sb.append("    _public: ").append(toIndentedString(_public)).append("\n");
    sb.append("    enableContentTrust: ").append(toIndentedString(enableContentTrust)).append("\n");
    sb.append("    preventVul: ").append(toIndentedString(preventVul)).append("\n");
    sb.append("    severity: ").append(toIndentedString(severity)).append("\n");
    sb.append("    autoScan: ").append(toIndentedString(autoScan)).append("\n");
    sb.append("    reuseSysCveWhitelist: ").append(toIndentedString(reuseSysCveWhitelist)).append("\n");
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
