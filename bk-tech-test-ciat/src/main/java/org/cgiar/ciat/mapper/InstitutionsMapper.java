package org.cgiar.ciat.mapper;

import org.cgiar.ciat.domain.Institutions;
import org.cgiar.ciat.dto.InstitutionsDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface InstitutionsMapper {
    @Mapping(source = "institutionTypes.id", target = "id_InstitutionTypes")
    public InstitutionsDTO institutionsToInstitutionsDTO(
        Institutions institutions) throws Exception;

    @Mapping(source = "id_InstitutionTypes", target = "institutionTypes.id")
    public Institutions institutionsDTOToInstitutions(
        InstitutionsDTO institutionsDTO) throws Exception;

    public List<InstitutionsDTO> listInstitutionsToListInstitutionsDTO(
        List<Institutions> institutionss) throws Exception;

    public List<Institutions> listInstitutionsDTOToListInstitutions(
        List<InstitutionsDTO> institutionsDTOs) throws Exception;
}
