package org.cgiar.ciat.mapper;

import org.cgiar.ciat.domain.LocElementTypes;
import org.cgiar.ciat.dto.LocElementTypesDTO;

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
public interface LocElementTypesMapper {
    public LocElementTypesDTO locElementTypesToLocElementTypesDTO(
        LocElementTypes locElementTypes) throws Exception;

    public LocElementTypes locElementTypesDTOToLocElementTypes(
        LocElementTypesDTO locElementTypesDTO) throws Exception;

    public List<LocElementTypesDTO> listLocElementTypesToListLocElementTypesDTO(
        List<LocElementTypes> locElementTypess) throws Exception;

    public List<LocElementTypes> listLocElementTypesDTOToListLocElementTypes(
        List<LocElementTypesDTO> locElementTypesDTOs) throws Exception;
}
