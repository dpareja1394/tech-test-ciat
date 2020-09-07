package org.cgiar.ciat.mapper;

import org.cgiar.ciat.domain.InstitutionTypes;
import org.cgiar.ciat.dto.InstitutionTypesDTO;

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
public interface InstitutionTypesMapper {
    public InstitutionTypesDTO institutionTypesToInstitutionTypesDTO(
        InstitutionTypes institutionTypes) throws Exception;

    public InstitutionTypes institutionTypesDTOToInstitutionTypes(
        InstitutionTypesDTO institutionTypesDTO) throws Exception;

    public List<InstitutionTypesDTO> listInstitutionTypesToListInstitutionTypesDTO(
        List<InstitutionTypes> institutionTypess) throws Exception;

    public List<InstitutionTypes> listInstitutionTypesDTOToListInstitutionTypes(
        List<InstitutionTypesDTO> institutionTypesDTOs)
        throws Exception;
}
