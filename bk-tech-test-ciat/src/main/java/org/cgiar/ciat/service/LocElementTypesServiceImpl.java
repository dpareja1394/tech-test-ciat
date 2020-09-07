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
public class LocElementTypesServiceImpl implements LocElementTypesService {
    private static final Logger log = LoggerFactory.getLogger(LocElementTypesServiceImpl.class);
    @Autowired
    private LocElementTypesRepository locElementTypesRepository;
    @Autowired
    private Validator validator;

    @Override
    public void validate(LocElementTypes locElementTypes)
        throws Exception {
        try {
            Set<ConstraintViolation<LocElementTypes>> constraintViolations = validator.validate(locElementTypes);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<LocElementTypes> constraintViolation : constraintViolations) {
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
        return locElementTypesRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocElementTypes> findAll() {
        log.debug("finding all LocElementTypes instances");

        return locElementTypesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public LocElementTypes save(LocElementTypes entity)
        throws Exception {
        log.debug("saving LocElementTypes instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "LocElementTypes");
            }

            validate(entity);

            if (locElementTypesRepository.findById(entity.getId()).isPresent()) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            return locElementTypesRepository.save(entity);
        } catch (Exception e) {
            log.error("save LocElementTypes failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(LocElementTypes entity) throws Exception {
        log.debug("deleting LocElementTypes instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("LocElementTypes");
        }

        if (entity.getId() == null) {
            throw new ZMessManager().new EmptyFieldException("id");
        }

        try {
            locElementTypesRepository.deleteById(entity.getId());
            log.debug("delete LocElementTypes successful");
        } catch (Exception e) {
            log.error("delete LocElementTypes failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteById(Long id) throws Exception {
        log.debug("deleting LocElementTypes instance");

        if (id == null) {
            throw new ZMessManager().new EmptyFieldException("id");
        }

        if (locElementTypesRepository.findById(id).isPresent()) {
            delete(locElementTypesRepository.findById(id).get());
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public LocElementTypes update(LocElementTypes entity)
        throws Exception {
        log.debug("updating LocElementTypes instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion(
                    "LocElementTypes");
            }

            validate(entity);

            return locElementTypesRepository.save(entity);
        } catch (Exception e) {
            log.error("update LocElementTypes failed", e);
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<LocElementTypes> findById(Long id)
        throws Exception {
        log.debug("getting LocElementTypes instance");

        return locElementTypesRepository.findById(id);
    }
}
