package org.cgiar.ciat.mapper;

import org.cgiar.ciat.domain.InstitutionsLocations;
import org.cgiar.ciat.dto.InstitutionsLocationsDTO;

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
public interface InstitutionsLocationsMapper {
    @Mapping(source = "institutions.id", target = "id_Institutions")
    @Mapping(source = "locElements.id", target = "id_LocElements")
    public InstitutionsLocationsDTO institutionsLocationsToInstitutionsLocationsDTO(
        InstitutionsLocations institutionsLocations) throws Exception;

    @Mapping(source = "id_Institutions", target = "institutions.id")
    @Mapping(source = "id_LocElements", target = "locElements.id")
    public InstitutionsLocations institutionsLocationsDTOToInstitutionsLocations(
        InstitutionsLocationsDTO institutionsLocationsDTO)
        throws Exception;

    public List<InstitutionsLocationsDTO> listInstitutionsLocationsToListInstitutionsLocationsDTO(
        List<InstitutionsLocations> institutionsLocationss)
        throws Exception;

    public List<InstitutionsLocations> listInstitutionsLocationsDTOToListInstitutionsLocations(
        List<InstitutionsLocationsDTO> institutionsLocationsDTOs)
        throws Exception;
}
