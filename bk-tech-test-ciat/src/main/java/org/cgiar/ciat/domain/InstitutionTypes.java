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
@Table(name = "institution_types", schema = "tech_test")
public class InstitutionTypes implements java.io.Serializable {
    @NotNull
    private Long id;
    private String acronym;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String name;
    private List<Institutions> institutionses = new ArrayList<Institutions>(0);

    public InstitutionTypes() {
    }

    public InstitutionTypes(Long id, String acronym,
        List<Institutions> institutionses, String name) {
        this.id = id;
        this.acronym = acronym;
        this.name = name;
        this.institutionses = institutionses;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "acronym")
    public String getAcronym() {
        return this.acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "institutionTypes")
    public List<Institutions> getInstitutionses() {
        return this.institutionses;
    }

    public void setInstitutionses(List<Institutions> institutionses) {
        this.institutionses = institutionses;
    }
}
