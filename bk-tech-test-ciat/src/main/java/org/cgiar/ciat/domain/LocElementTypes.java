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
@Table(name = "loc_element_types", schema = "tech_test")
public class LocElementTypes implements java.io.Serializable {
    @NotNull
    private Long id;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String isActive;
    private String name;

    public LocElementTypes() {
    }

    public LocElementTypes(Long id, String isActive, String name) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "is_active", nullable = false)
    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
