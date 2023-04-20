package de.thdeg.systemdesign.server;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Boot
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-04-20T12:22:40.827252+02:00[Europe/Berlin]")


public class Boot   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("created")
  private OffsetDateTime created = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("sitze")
  private Integer sitze = null;

  @JsonProperty("klasse")
  private String klasse = null;

  public Boot id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Die ID des Boots
   * @return id
   **/
  @Schema(example = "2", description = "Die ID des Boots")
  
    public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Boot created(OffsetDateTime created) {
    this.created = created;
    return this;
  }

  /**
   * Wann das Boot angelegt wurde
   * @return created
   **/
  @Schema(example = "2017-07-21T17:32:28Z", description = "Wann das Boot angelegt wurde")
  
    @Valid
    public OffsetDateTime getCreated() {
    return created;
  }

  public void setCreated(OffsetDateTime created) {
    this.created = created;
  }

  public Boot name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name des Bootes
   * @return name
   **/
  @Schema(example = "Boaty McBoatface", description = "Name des Bootes")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boot sitze(Integer sitze) {
    this.sitze = sitze;
    return this;
  }

  /**
   * Anzahl der Sitzplätze
   * @return sitze
   **/
  @Schema(example = "3", description = "Anzahl der Sitzplätze")
  
    public Integer getSitze() {
    return sitze;
  }

  public void setSitze(Integer sitze) {
    this.sitze = sitze;
  }

  public Boot klasse(String klasse) {
    this.klasse = klasse;
    return this;
  }

  /**
   * Bootstyp
   * @return klasse
   **/
  @Schema(example = "A", description = "Bootstyp")
  
    public String getKlasse() {
    return klasse;
  }

  public void setKlasse(String klasse) {
    this.klasse = klasse;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Boot boot = (Boot) o;
    return Objects.equals(this.id, boot.id) &&
        Objects.equals(this.created, boot.created) &&
        Objects.equals(this.name, boot.name) &&
        Objects.equals(this.sitze, boot.sitze) &&
        Objects.equals(this.klasse, boot.klasse);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, created, name, sitze, klasse);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Boot {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    created: ").append(toIndentedString(created)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    sitze: ").append(toIndentedString(sitze)).append("\n");
    sb.append("    klasse: ").append(toIndentedString(klasse)).append("\n");
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
