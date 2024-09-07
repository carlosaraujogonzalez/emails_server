package com.gbtec.emailserver.service;


import com.gbtec.openapi.model.Email;
import com.gbtec.openapi.model.Emails;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient( name="userFeignClient", url="${emails.db.microservice.path}")
public interface UserFeignClient {

    @PostMapping( value="/emails", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addEmails(@RequestBody Emails request);
    
    @GetMapping( value="/emails", produces = MediaType.APPLICATION_JSON_VALUE)
    public Emails getEmails();
    
    @DeleteMapping( value="/emails")
    public void deleteEmails();
    
    @GetMapping( value="/emails/{emailId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Email findEmailById(@PathVariable int emailId);
    
    @PutMapping( value="/emails/{emailId}", consumes = { "application/json" })
    public void updateEmail(@RequestBody Email email, @PathVariable int emailId);
    
    @DeleteMapping ( value="/emails/{emailId}")
    public void deleteEmailById(@PathVariable int emailId);
    
    @PostMapping(value="/emails/markSpam/{email}")
    public void markSpam(@PathVariable String email);

}
