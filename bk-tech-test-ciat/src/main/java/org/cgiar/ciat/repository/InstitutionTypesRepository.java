package org.cgiar.ciat.repository;

import org.cgiar.ciat.domain.InstitutionTypes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   InstitutionTypesRepository.
*
*/
public interface InstitutionTypesRepository extends JpaRepository<InstitutionTypes, Long> {
}
