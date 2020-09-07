package org.cgiar.ciat.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.util.Date;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class InstitutionsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(InstitutionsDTO.class);
    private String acronym;
    private Date added;
    private Long id;
    private String name;
    private Long programId;
    private String websiteLink;
    private Long id_InstitutionTypes;

    /**
     * Add, mapping the name of the Institution Type
     * @author Daniel Pareja Londoño
     * @version sep 06, 2020
     * @since 1.8
     *
     */
    private String name_InstitutionTypes;
    
    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getProgramId() {
        return programId;
    }

    public void setProgramId(Long programId) {
        this.programId = programId;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public Long getId_InstitutionTypes() {
        return id_InstitutionTypes;
    }

    public void setId_InstitutionTypes(Long id_InstitutionTypes) {
        this.id_InstitutionTypes = id_InstitutionTypes;
    }

    /**
	 *
	 * @author Daniel Pareja Londoño
	 * @version sep 06, 2020
	 * @since 1.8
	 * @return El/La name_InstitutionTypes
	 *
	 */
	public String getName_InstitutionTypes() {
		return name_InstitutionTypes;
	}

	/**
	 *
	 * @param name_InstitutionTypes El/La name_InstitutionTypes a setear
	 * @author Daniel Pareja Londoño
	 * @version sep 06, 2020
	 * @since 1.8
	 *
	 */
	public void setName_InstitutionTypes(String name_InstitutionTypes) {
		this.name_InstitutionTypes = name_InstitutionTypes;
	}

	@Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());

            return super.toString();
        }
    }
}
