package com.ubikee.portic.core;

import java.util.LinkedHashMap;

import org.apache.commons.lang.Validate;

/**
 * Model map
 * 
 * @author ernesto
 *
 */
public class Model extends LinkedHashMap<String, Object> {
	
	/**
	 * Construct a new, empty <code>Model</code>.
	 */
	public Model() {
	}

	/**
	 * Add the given attribute under the given name
	 * 
	 * @param attributeName never <code>null</code>
	 * @param attributeValue can be <code>null</code>
	 * @return
	 */
	public Model addAttribute(String attributeName, Object attributeValue) {
		Validate.notNull(attributeName, "Model attribute name must not be null");
		put(attributeName, attributeValue);
		return this;
	}

	/**
	 * 
	 * @param attributeName
	 * @return
	 */
	public boolean containsAttribute(String attributeName) {
		return containsKey(attributeName);
	}
	
}
