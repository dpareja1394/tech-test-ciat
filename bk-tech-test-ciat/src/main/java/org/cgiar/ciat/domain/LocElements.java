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
@Table(name = "loc_elements", schema = "tech_test")
public class LocElements implements java.io.Serializable {
    @NotNull
    private Long id;
    private Long elementTypeId;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String isActive;
    private String isoAlpha2;
    @NotNull
    @NotEmpty
    @Size(max = 65535)
    private String name;
    private Long parentId;
    private List<InstitutionsLocations> institutionsLocationses = new ArrayList<InstitutionsLocations>(0);

    public LocElements() {
    }

    public LocElements(Long id, Long elementTypeId,
        List<InstitutionsLocations> institutionsLocationses, String isActive,
        String isoAlpha2, String name, Long parentId) {
        this.id = id;
        this.elementTypeId = elementTypeId;
        this.isActive = isActive;
        this.isoAlpha2 = isoAlpha2;
        this.name = name;
        this.parentId = parentId;
        this.institutionsLocationses = institutionsLocationses;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "element_type_id")
    public Long getElementTypeId() {
        return this.elementTypeId;
    }

    public void setElementTypeId(Long elementTypeId) {
        this.elementTypeId = elementTypeId;
    }

    @Column(name = "is_active", nullable = false)
    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Column(name = "iso_alpha_2")
    public String getIsoAlpha2() {
        return this.isoAlpha2;
    }

    public void setIsoAlpha2(String isoAlpha2) {
        this.isoAlpha2 = isoAlpha2;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "parent_id")
    public Long getParentId() {
        return this.parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locElements")
    public List<InstitutionsLocations> getInstitutionsLocationses() {
        return this.institutionsLocationses;
    }

    public void setInstitutionsLocationses(
        List<InstitutionsLocations> institutionsLocationses) {
        this.institutionsLocationses = institutionsLocationses;
    }
}
