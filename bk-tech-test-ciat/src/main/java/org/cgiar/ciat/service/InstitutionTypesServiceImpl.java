package  org.cgiar.ciat.service;


import java.math.*;
import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.cgiar.ciat.exception.*;
import org.cgiar.ciat.repository.*;
import org.cgiar.ciat.utility.Utilities;

import org.cgiar.ciat.domain.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
* @author Zathura Code Generator http://zathuracode.org/
* www.zathuracode.org
* 
*/

@Scope("singleton")
@Service
public class InstitutionTypesServiceImpl implements InstitutionTypesService{

	private static final Logger log = LoggerFactory.getLogger(InstitutionTypesServiceImpl.class);

	@Autowired
	private InstitutionTypesRepository institutionTypesRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(InstitutionTypes institutionTypes)throws Exception{		
		 try {
			Set<ConstraintViolation<InstitutionTypes>> constraintViolations =validator.validate(institutionTypes);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<InstitutionTypes> constraintViolation : constraintViolations) {
					strMessage.append(constraintViolation.getPropertyPath().toString());
					strMessage.append(" - ");
					strMessage.append(constraintViolation.getMessage());
					strMessage.append(". \n");
				}
				 throw new Exception(strMessage.toString());
			 }
		 }catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	@Transactional(readOnly=true)
	public Long count(){
	 	return institutionTypesRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<InstitutionTypes> findAll(){
		log.debug("finding all InstitutionTypes instances");
       	return institutionTypesRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public InstitutionTypes save(InstitutionTypes entity) throws Exception {
		log.debug("saving InstitutionTypes instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("InstitutionTypes");
		}
		
		validate(entity);	
	
		if(institutionTypesRepository.findById(entity.getId()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return institutionTypesRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save InstitutionTypes failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(InstitutionTypes entity) throws Exception {
            	log.debug("deleting InstitutionTypes instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("InstitutionTypes");
	    		}
    	
                                if(entity.getId()==null){
                    throw new ZMessManager().new EmptyFieldException("id");
                    }
                        
            	            findById(entity.getId()).ifPresent(entidad->{	            	
	                													List<Institutions> institutionses = entidad.getInstitutionses();
	                    	                    if(Utilities.validationsList(institutionses)==true){
                       	 	throw new ZMessManager().new DeletingException("institutionses");
                        }
	                	            });
                       

            try {
            
            institutionTypesRepository.deleteById(entity.getId());
            log.debug("delete InstitutionTypes successful");
            
            } catch (Exception e) {
            	log.error("delete InstitutionTypes failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Long id) throws Exception {            
            	log.debug("deleting InstitutionTypes instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("id");
            	}
            	if(institutionTypesRepository.findById(id).isPresent()){
           			delete(institutionTypesRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public InstitutionTypes update(InstitutionTypes entity) throws Exception {

				log.debug("updating InstitutionTypes instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("InstitutionTypes");
		    		}
		    		
	            validate(entity);
	
	            return institutionTypesRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update InstitutionTypes failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<InstitutionTypes> findById(Long id) throws Exception {            
            	log.debug("getting InstitutionTypes instance");
            	return institutionTypesRepository.findById(id);
            }
			
}
