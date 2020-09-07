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
public class LocElementsServiceImpl implements LocElementsService{

	private static final Logger log = LoggerFactory.getLogger(LocElementsServiceImpl.class);

	@Autowired
	private LocElementsRepository locElementsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(LocElements locElements)throws Exception{		
		 try {
			Set<ConstraintViolation<LocElements>> constraintViolations =validator.validate(locElements);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<LocElements> constraintViolation : constraintViolations) {
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
	 	return locElementsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<LocElements> findAll(){
		log.debug("finding all LocElements instances");
       	return locElementsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public LocElements save(LocElements entity) throws Exception {
		log.debug("saving LocElements instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("LocElements");
		}
		
		validate(entity);	
	
		if(locElementsRepository.findById(entity.getId()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return locElementsRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save LocElements failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(LocElements entity) throws Exception {
            	log.debug("deleting LocElements instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("LocElements");
	    		}
    	
                                if(entity.getId()==null){
                    throw new ZMessManager().new EmptyFieldException("id");
                    }
                        
            	            findById(entity.getId()).ifPresent(entidad->{	            	
	                													List<InstitutionsLocations> institutionsLocationses = entidad.getInstitutionsLocationses();
	                    	                    if(Utilities.validationsList(institutionsLocationses)==true){
                       	 	throw new ZMessManager().new DeletingException("institutionsLocationses");
                        }
	                	            });
                       

            try {
            
            locElementsRepository.deleteById(entity.getId());
            log.debug("delete LocElements successful");
            
            } catch (Exception e) {
            	log.error("delete LocElements failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Long id) throws Exception {            
            	log.debug("deleting LocElements instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("id");
            	}
            	if(locElementsRepository.findById(id).isPresent()){
           			delete(locElementsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public LocElements update(LocElements entity) throws Exception {

				log.debug("updating LocElements instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("LocElements");
		    		}
		    		
	            validate(entity);
	
	            return locElementsRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update LocElements failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<LocElements> findById(Long id) throws Exception {            
            	log.debug("getting LocElements instance");
            	return locElementsRepository.findById(id);
            }
			
}
