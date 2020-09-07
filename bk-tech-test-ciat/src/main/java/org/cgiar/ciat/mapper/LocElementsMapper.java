package org.cgiar.ciat.mapper;

import org.cgiar.ciat.domain.LocElements;
import org.cgiar.ciat.dto.LocElementsDTO;

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
public interface LocElementsMapper {
    public LocElementsDTO locElementsToLocElementsDTO(LocElements locElements)
        throws Exception;

    public LocElements locElementsDTOToLocElements(
        LocElementsDTO locElementsDTO) throws Exception;

    public List<LocElementsDTO> listLocElementsToListLocElementsDTO(
        List<LocElements> locElementss) throws Exception;

    public List<LocElements> listLocElementsDTOToListLocElements(
        List<LocElementsDTO> locElementsDTOs) throws Exception;
}
