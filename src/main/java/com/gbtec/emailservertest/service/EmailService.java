package com.gbtec.emailservertest.service;

import com.gbtec.openapi.model.Emails;

public interface EmailService {

    /**
     * Create emails with these 4 states: 1-Enviado, 2-Borrador, 3-Eliminado, 4-Spam
     * @param emails
     */
    public void addEmails(Emails request);
    
    /**
     * Read all the emails saved in the server
     */
    public Emails getEmails();
 
    /**
     * Delete all the emails saved in the server
     */
    public void deleteEmails();
}
