package com.ubikee.portic.core.module.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Attach a mode to the annotated method.
 * 
 * @author ernesto
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleMode {
	
	public static String VIEW = "VIEW";
	public static String EDIT = "EDIT";
	public static String HELP = "HELP";
	public static String ERROR = "ERROR";
	
	/**
	 * @return
	 */
	String value();
	
}
