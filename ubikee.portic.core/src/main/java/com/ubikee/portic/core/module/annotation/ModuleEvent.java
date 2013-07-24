package com.ubikee.portic.core.module.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Attach an event to the annotated method.
 * 
 * @author ernesto
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleEvent {
	
	/**
	 * 
	 * @return 
	 */
	String value();
	
}
