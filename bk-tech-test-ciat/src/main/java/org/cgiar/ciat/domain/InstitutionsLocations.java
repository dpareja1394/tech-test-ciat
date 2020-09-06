package org.cgiar.ciat.domain;

import java.util.Date;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "institutions_locations", schema = "tech_test")
public class InstitutionsLocations implements java.io.Serializable {
	
	@Id
	@NotNull
    private Long id;
    @NotNull
    private Institutions institutions;
    @NotNull
    private LocElements locElements;
    private String city;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String isHeadquater;

    public InstitutionsLocations() {
    }

    public InstitutionsLocations(Long id, String city,
        Institutions institutions, String isHeadquater, LocElements locElements) {
        this.id = id;
        this.institutions = institutions;
        this.locElements = locElements;
        this.city = city;
        this.isHeadquater = isHeadquater;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false, insertable=false, updatable=false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "institution_id", insertable=false, updatable=false)
    public Institutions getInstitutions() {
        return this.institutions;
    }

    public void setInstitutions(Institutions institutions) {
        this.institutions = institutions;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loc_element_id", insertable=false, updatable=false)
    public LocElements getLocElements() {
        return this.locElements;
    }

    public void setLocElements(LocElements locElements) {
        this.locElements = locElements;
    }

    @Column(name = "city")
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "is_headquater", nullable = false)
    public String getIsHeadquater() {
        return this.isHeadquater;
    }

    public void setIsHeadquater(String isHeadquater) {
        this.isHeadquater = isHeadquater;
    }
}
