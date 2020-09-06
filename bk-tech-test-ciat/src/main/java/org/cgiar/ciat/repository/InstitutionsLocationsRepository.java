package org.cgiar.ciat.repository;

import org.cgiar.ciat.domain.InstitutionsLocations;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   InstitutionsLocationsRepository.
*
*/
public interface InstitutionsLocationsRepository extends JpaRepository<InstitutionsLocations, Long> {
}
