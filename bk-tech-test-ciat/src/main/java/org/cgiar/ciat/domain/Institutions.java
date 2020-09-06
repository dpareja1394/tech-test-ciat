package org.cgiar.ciat.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "institutions", schema = "tech_test")
public class Institutions implements java.io.Serializable {
    @NotNull
    private Long id;
    @NotNull
    private InstitutionTypes institutionTypes;
    private String acronym;
    @NotNull
    private Date added;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String name;
    private Long programId;
    private String websiteLink;
    private List<InstitutionsLocations> institutionsLocationses = new ArrayList<InstitutionsLocations>(0);

    public Institutions() {
    }

    public Institutions(Long id, String acronym, Date added,
        InstitutionTypes institutionTypes,
        List<InstitutionsLocations> institutionsLocationses, String name,
        Long programId, String websiteLink) {
        this.id = id;
        this.institutionTypes = institutionTypes;
        this.acronym = acronym;
        this.added = added;
        this.name = name;
        this.programId = programId;
        this.websiteLink = websiteLink;
        this.institutionsLocationses = institutionsLocationses;
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
    @JoinColumn(name = "institution_type_id", insertable=false, updatable=false)
    public InstitutionTypes getInstitutionTypes() {
        return this.institutionTypes;
    }

    public void setInstitutionTypes(InstitutionTypes institutionTypes) {
        this.institutionTypes = institutionTypes;
    }

    @Column(name = "acronym")
    public String getAcronym() {
        return this.acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Column(name = "added", nullable = false)
    public Date getAdded() {
        return this.added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "program_id")
    public Long getProgramId() {
        return this.programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    @Column(name = "website_link")
    public String getWebsiteLink() {
        return this.websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institutions")
    public List<InstitutionsLocations> getInstitutionsLocationses() {
        return this.institutionsLocationses;
    }

    public void setInstitutionsLocationses(
        List<InstitutionsLocations> institutionsLocationses) {
        this.institutionsLocationses = institutionsLocationses;
    }
}
