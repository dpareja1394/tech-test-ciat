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
public class InstitutionsLocationsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(InstitutionsLocationsDTO.class);
    private String city;
    private Long id;
    private String isHeadquater;
    private Long id_Institutions;
    private Long id_LocElements;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsHeadquater() {
        return isHeadquater;
    }

    public void setIsHeadquater(String isHeadquater) {
        this.isHeadquater = isHeadquater;
    }

    public Long getId_Institutions() {
        return id_Institutions;
    }

    public void setId_Institutions(Long id_Institutions) {
        this.id_Institutions = id_Institutions;
    }

    public Long getId_LocElements() {
        return id_LocElements;
    }

    public void setId_LocElements(Long id_LocElements) {
        this.id_LocElements = id_LocElements;
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
