package com.cop.dao;

public class SystemCheckedException extends Exception {

    /**
     * Just to stop warnings.
     */
    private static final long serialVersionUID = 1L;

    public SystemCheckedException(String message){
        super(message);
    }
}
