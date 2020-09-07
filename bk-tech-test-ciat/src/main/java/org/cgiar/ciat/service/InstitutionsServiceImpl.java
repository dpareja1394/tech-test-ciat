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
public class InstitutionsServiceImpl implements InstitutionsService{

	private static final Logger log = LoggerFactory.getLogger(InstitutionsServiceImpl.class);

	@Autowired
	private InstitutionsRepository institutionsRepository;
	
	@Autowired
	private Validator validator;
                
    @Override        		
	public void validate(Institutions institutions)throws Exception{		
		 try {
			Set<ConstraintViolation<Institutions>> constraintViolations =validator.validate(institutions);
			 if(constraintViolations.size()>0){
				 StringBuilder strMessage=new StringBuilder();
				 for (ConstraintViolation<Institutions> constraintViolation : constraintViolations) {
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
	 	return institutionsRepository.count();
	}

	@Override
	@Transactional(readOnly=true)
	public List<Institutions> findAll(){
		log.debug("finding all Institutions instances");
       	return institutionsRepository.findAll();
    }
			
			
	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)			
    public Institutions save(Institutions entity) throws Exception {
		log.debug("saving Institutions instance");
	    try {
	    
	    if(entity==null){
			throw new ZMessManager().new NullEntityExcepcion("Institutions");
		}
		
		validate(entity);	
	
		if(institutionsRepository.findById(entity.getId()).isPresent()){
           throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
        }    
	
	    return institutionsRepository.save(entity);
	    
	    } catch (Exception e) {
	    	log.error("save Institutions failed", e);
	    	throw e;
	    }
    }
			
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void delete(Institutions entity) throws Exception {
            	log.debug("deleting Institutions instance");
            	
	            if(entity==null){
	    			throw new ZMessManager().new NullEntityExcepcion("Institutions");
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
            
            institutionsRepository.deleteById(entity.getId());
            log.debug("delete Institutions successful");
            
            } catch (Exception e) {
            	log.error("delete Institutions failed", e);
            	throw e;
            }
            	
            }
            
            @Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public void deleteById(Long id) throws Exception {            
            	log.debug("deleting Institutions instance");
            	if(id==null){
            		throw new ZMessManager().new EmptyFieldException("id");
            	}
            	if(institutionsRepository.findById(id).isPresent()){
           			delete(institutionsRepository.findById(id).get());
       			}    
            }	
			
			@Override
			@Transactional(readOnly=false , propagation=Propagation.REQUIRED)
            public Institutions update(Institutions entity) throws Exception {

				log.debug("updating Institutions instance");
				
	            try {
	            
	            	if(entity==null){
		    			throw new ZMessManager().new NullEntityExcepcion("Institutions");
		    		}
		    		
	            validate(entity);
	
	            return institutionsRepository.save(entity);
	            
	            } catch (Exception e) {
	            	log.error("update Institutions failed", e);
	            	throw e;		
	            }
            }
			
			@Override
			@Transactional(readOnly=true)
            public Optional<Institutions> findById(Long id) throws Exception {            
            	log.debug("getting Institutions instance");
            	return institutionsRepository.findById(id);
            }
			
}
