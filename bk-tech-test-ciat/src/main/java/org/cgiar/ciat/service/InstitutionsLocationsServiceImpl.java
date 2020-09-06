package org.cgiar.ciat.service;

import org.cgiar.ciat.domain.*;
import org.cgiar.ciat.exception.*;
import org.cgiar.ciat.repository.*;
import org.cgiar.ciat.utility.Utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Scope;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.*;

import java.util.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service
public class InstitutionsLocationsServiceImpl
    implements InstitutionsLocationsService {
    private static final Logger log = LoggerFactory.getLogger(InstitutionsLocationsServiceImpl.class);
    @Autowired
    private InstitutionsLocationsRepository institutionsLocationsRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(InstitutionsLocations institutionsLocations)
        throws Exception {
        try {
            Set<ConstraintViolation<InstitutionsLocations>> constraintViolations =
                validator.validate(institutionsLocations);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<InstitutionsLocations> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long count() {
        return institutionsLocationsRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<InstitutionsLocations> findAll() {
        log.debug("finding all InstitutionsLocations instances");

        return institutionsLocationsRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public InstitutionsLocations save(InstitutionsLocations entity)
        throws Exception {
        log.debug("saving InstitutionsLocations instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "InstitutionsLocations");
            }

            validate(entity);

            if (institutionsLocationsRepository.findById(entity.getId())
                                                   .isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            return institutionsLocationsRepository.save(entity);
        } catch (Exception e) {
            log.error("save InstitutionsLocations failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(InstitutionsLocations entity) throws Exception {
        log.debug("deleting InstitutionsLocations instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion(
                "InstitutionsLocations");
        }

        if (entity.getId() == null) {
            throw new ZMessManager().new EmptyFieldException("id");
        }

        try {
            institutionsLocationsRepository.deleteById(entity.getId());
            log.debug("delete InstitutionsLocations successful");
        } catch (Exception e) {
            log.error("delete InstitutionsLocations failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting InstitutionsLocations instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("id");
        }

        if (institutionsLocationsRepository.findById(id).isPresent()) {
            delete(institutionsLocationsRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public InstitutionsLocations update(InstitutionsLocations entity)
        throws Exception {
        log.debug("updating InstitutionsLocations instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "InstitutionsLocations");
            }

            validate(entity);

            return institutionsLocationsRepository.save(entity);
        } catch (Exception e) {
            log.error("update InstitutionsLocations failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<InstitutionsLocations> findById(Long id)
        throws Exception {
        log.debug("getting InstitutionsLocations instance");

        return institutionsLocationsRepository.findById(id);
    }
}
