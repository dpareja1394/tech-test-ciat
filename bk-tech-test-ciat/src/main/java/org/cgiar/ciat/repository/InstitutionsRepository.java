package org.cgiar.ciat.repository;

import org.cgiar.ciat.domain.Institutions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   InstitutionsRepository.
*
*/
public interface InstitutionsRepository extends JpaRepository<Institutions, Long> {
}
