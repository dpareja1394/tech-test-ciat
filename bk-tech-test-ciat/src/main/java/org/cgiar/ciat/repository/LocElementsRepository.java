package org.cgiar.ciat.repository;

import org.cgiar.ciat.domain.LocElements;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;


/**
* Interface for   LocElementsRepository.
*
*/
public interface LocElementsRepository extends JpaRepository<LocElements, Long> {
}
