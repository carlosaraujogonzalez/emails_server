package com.gbtec.emailservertest.exceptions;

public class EmailExistsException extends RuntimeException {
	
    public EmailExistsException(String message) {
    	
        super(message);
    }

}