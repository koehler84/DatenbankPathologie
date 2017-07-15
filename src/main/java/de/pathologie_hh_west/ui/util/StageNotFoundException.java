package de.pathologie_hh_west.ui.util;

/**
 * Created by eike on 15.07.2017.
 */
public class StageNotFoundException extends RuntimeException {
	
	public StageNotFoundException() {
	}
	
	public StageNotFoundException(String message) {
		super(message);
	}
	
	public StageNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public StageNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public StageNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
