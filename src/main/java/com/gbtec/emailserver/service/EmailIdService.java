package com.gbtec.emailserver.service;

import com.gbtec.openapi.model.Email;

public interface EmailIdService {

    /**
     * Read the email with the corresponding emailId
     * @param emailId
     */
    public Email getEmail(int emailId);

    /**
     * Delete the email with the indicated emailId
     * @param emailId
     */
    public void deleteEmail(int emailId);

    /**
     * Update the email with the indicated emailId
     * @param emailId
     * @throws UpdateFailedException 
     * @throws Throwable 
     * @throws Exception 
     */
    public void updateEmail(Email email, int emailId) throws Exception;
}
