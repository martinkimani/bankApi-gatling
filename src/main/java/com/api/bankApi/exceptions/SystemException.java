package com.api.bankApi.exceptions;

/**
 *
 * @author martin
 */
public class SystemException extends RuntimeException {
    
    public SystemException(String message) {
        super(message);
    }
}
