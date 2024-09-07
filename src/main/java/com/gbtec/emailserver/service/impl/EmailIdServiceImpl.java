package com.gbtec.emailserver.service.impl;

import com.gbtec.openapi.model.Email;
import com.gbtec.emailserver.exceptions.UpdateFailedException;
import com.gbtec.emailserver.service.EmailIdService;
import com.gbtec.emailserver.service.UserFeignClient;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailIdServiceImpl implements EmailIdService {

	@Autowired
	UserFeignClient userFeignClient;
	
    @Override
    public Email getEmail(int emailId) {

    	log.info("getEmail - Start: " + emailId);
    	
    	var email = userFeignClient.findEmailById( emailId);
    	
    	log.info("getEmail - End: " + email);
    	return email;
    }

    @Override
    public void deleteEmail(int emailId) {
    	
    	log.info("deleteEmail - Start: " + emailId);
    	
    	userFeignClient.deleteEmailById( emailId);
    	
    	log.info("deleteEmail - End");
    }

    @Override
    public void updateEmail(Email email, int emailId) throws Exception {

    	log.info("updateEmail - Start, email: " + email + ", emailId: " + emailId);
    	
    	try{
    		
    		userFeignClient.updateEmail( email, emailId);
    	}catch(Exception e) {
    		
    		throw new UpdateFailedException("No se ha podido actualizar el email"); 
    	}
    		
    	
    	log.info("updateEmail - Start: ");
    }


}
