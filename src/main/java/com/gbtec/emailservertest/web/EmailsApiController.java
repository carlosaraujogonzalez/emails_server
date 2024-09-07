package com.gbtec.emailservertest.web;

import com.gbtec.emailservertest.service.EmailService;
import com.gbtec.openapi.api.EmailsApi;
import com.gbtec.openapi.model.Emails;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
public class EmailsApiController implements EmailsApi {

    @Autowired
    EmailService emailService;
    
    public ResponseEntity<Void> addEmails(
    		@Parameter(name = "InputRequest", description = "", required = true) @Valid @RequestBody Emails inputRequest) {

        log.info("EmailsApiController - addEmails - Started");

        emailService.addEmails( inputRequest);

        log.info("EmailsApiController - addEmails - End");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Emails> getEmails() {

        log.info("EmailsApiController - getEmails - Started");

        var listEmails = emailService.getEmails();

        log.info("EmailsApiController - getEmails - End");

        return new ResponseEntity<>(listEmails, HttpStatus.OK);
    }
    
    public ResponseEntity<Void> deleteEmails() {

        log.info("EmailsApiController - deleteEmails - Started");

        emailService.deleteEmails();

        log.info("EmailsApiController - deleteEmails - End");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
