package com.gbtec.emailserver.exceptions;

public class EmailExistsException extends RuntimeException {
	
    public EmailExistsException(String message) {
    	
        super(message);
    }

}