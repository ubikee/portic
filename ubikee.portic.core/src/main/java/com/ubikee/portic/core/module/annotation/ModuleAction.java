package com.ubikee.portic.core.module.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Attach an action name to the annotated method.
 * 
 * @author ernesto
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleAction {
	
	/**
	 * @return
	 */
	String value();
	
}
