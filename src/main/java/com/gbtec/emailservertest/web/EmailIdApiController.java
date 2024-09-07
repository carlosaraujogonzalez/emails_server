package com.gbtec.emailservertest.web;

import com.gbtec.openapi.api.EmailsIdApi;
import com.gbtec.openapi.model.Email;
import com.gbtec.emailservertest.service.EmailIdService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
public class EmailIdApiController implements EmailsIdApi {

    @Autowired
    EmailIdService emailIdService;

    public ResponseEntity<Email> findEmailById(
            @Parameter(name = "emailId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("emailId") Integer emailId
    ) {

        log.info("findEmailById - Started");

        var email = emailIdService.getEmail(emailId);

        log.info("findEmailById - End");

        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteEmailById(
            @Parameter(name = "emailId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("emailId") Integer emailId
    ) {

        log.info("deleteEmailById - Started");

        emailIdService.deleteEmail(emailId);

        log.info("deleteEmailById - End");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Void> updateEmailById(
            @Parameter(name = "emailId", description = "", required = true, in = ParameterIn.PATH) @PathVariable("emailId") Integer emailId,
            @Parameter(name = "Email", description = "", required = true) @Valid @RequestBody Email email
    ) throws Exception{

        log.info("updateEmailById - Started");

        emailIdService.updateEmail(email, emailId);
 
        log.info("updateEmailById - End");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
