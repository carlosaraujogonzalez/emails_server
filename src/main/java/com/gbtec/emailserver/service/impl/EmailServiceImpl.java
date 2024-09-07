package com.gbtec.emailserver.service.impl;

import com.gbtec.openapi.model.Emails;
import com.gbtec.emailserver.exceptions.EmailExistsException;

import com.gbtec.emailserver.service.EmailService;
import com.gbtec.emailserver.service.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    //private JavaMailSender javaMailSender;
	@Autowired
    private final UserFeignClient userFeignClient;

    @Override
    public void addEmails(Emails request) {

        log.info("addEmails - Start - request: " + request);

    	try{
    		
    		userFeignClient.addEmails(request);
    	}catch(Exception e) {
    		
    		throw new EmailExistsException("No se ha podido actualizar el email"); 
    	}
        

        log.info("addEmails - End");
    }

    @Override
    public Emails getEmails() {

        log.info("EmailServiceImpl - getEmails - Start");

        var listEmails = userFeignClient.getEmails();

        log.info("EmailServiceImpl - getEmails - End");
        return listEmails;
    }

    @Override
    public void deleteEmails() {
    	
        log.info("EmailServiceImpl - deleteEmails - Start");

        userFeignClient.deleteEmails();

        log.info("EmailServiceImpl - deleteEmails - End");
    }

    /*private SimpleMailMessage getSimpleMailMessageFromEmail( Email email){

        log.info("getSimpleMailMessage: " + email);

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom( email.getEmailFrom());
        simpleMailMessage.setTo( getEmailsTo(email));
        simpleMailMessage.setCc( getEmailsCc(email));
        simpleMailMessage.setText( email.getEmailBody());

        log.info("getSimpleMailMessage: " + simpleMailMessage);

        return simpleMailMessage;
    }*/
    
    
    /*private String[] getEmailsTo(Email email){

        log.info("getEmailsTo: " + email);

        String[] emailsto = new String[0];
        email.getEmailTo().forEach( emailto -> Arrays.stream( emailsto).toList().add( emailto.getEmail()));

        log.info("getEmailsTo: " + Arrays.toString( emailsto));

        return emailsto;
    }

    private String[] getEmailsCc(Email email){

        log.info("getEmailsCc: " + email);

        String[] emailscc = new String[0];
        email.getEmailCC().forEach(emailcc -> Arrays.stream(emailscc).toList().add(emailcc.getEmail()));

        log.info("getEmailsCc: " + Arrays.toString(emailscc));

        return emailscc;
    }*/
}
