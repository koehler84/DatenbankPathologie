package de.pathologie_hh_west.service;

public class ColumnHeadersNotFoundException extends Exception {
	
	public ColumnHeadersNotFoundException() {
	}
	
	public ColumnHeadersNotFoundException(String message) {
		super(message);
	}
	
	public ColumnHeadersNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ColumnHeadersNotFoundException(Throwable cause) {
		super(cause);
	}
	
	public ColumnHeadersNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
