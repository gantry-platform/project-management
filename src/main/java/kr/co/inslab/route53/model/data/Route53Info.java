package kr.co.inslab.route53.model.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import kr.co.inslab.gantry.data.GantryInfo;
import kr.co.inslab.route53.model.Record;
import kr.co.inslab.route53.model.Zone;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Route53Info
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-07-31T16:32:09.615+09:00[Asia/Seoul]")
@Document(collection = "route53")
public class Route53Info   {
  @JsonProperty("id")
  @Id
  private String id = null;

  @JsonProperty("gantry")
  private GantryInfo gantry = null;

  @JsonProperty("zone")
  private Zone zone = null;

  @JsonProperty("record")
  private Record record = null;

  public Route53Info id(String id) {
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

  public Route53Info gantry(GantryInfo gantry) {
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

  public Route53Info zone(Zone zone) {
    this.zone = zone;
    return this;
  }

  /**
   * Get zone
   * @return zone
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Zone getZone() {
    return zone;
  }

  public void setZone(Zone zone) {
    this.zone = zone;
  }

  public Route53Info record(Record record) {
    this.record = record;
    return this;
  }

  /**
   * Get record
   * @return record
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Record getRecord() {
    return record;
  }

  public void setRecord(Record record) {
    this.record = record;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route53Info route53Info = (Route53Info) o;
    return Objects.equals(this.id, route53Info.id) &&
        Objects.equals(this.gantry, route53Info.gantry) &&
        Objects.equals(this.zone, route53Info.zone) &&
        Objects.equals(this.record, route53Info.record);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, gantry, zone, record);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Route53Info {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    gantry: ").append(toIndentedString(gantry)).append("\n");
    sb.append("    zone: ").append(toIndentedString(zone)).append("\n");
    sb.append("    record: ").append(toIndentedString(record)).append("\n");
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
