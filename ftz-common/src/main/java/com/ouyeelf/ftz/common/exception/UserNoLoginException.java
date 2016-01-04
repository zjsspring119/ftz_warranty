package com.ouyeelf.ftz.common.exception;

public class UserNoLoginException extends Exception{
	
	 /**
     * Constructs a <code>UserNoLoginException</code> with no detail message.
     */
    public UserNoLoginException() {
	super();
    }

    /**
     * Constructs a <code>NullPointerException</code> with the specified 
     * detail message. 
     *
     * @param   s   the detail message.
     */
    public UserNoLoginException(String s) {
	super(s);
    }

}
