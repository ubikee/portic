package com.ubikee.portic.core.module.form;

import java.util.Collection;
import java.util.Set;

import com.ubikee.portic.core.Model;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * 
 * @author ernesto
 *
 */
public class DynaForm extends Form {

	Model model;

	/**
	 * 
	 */
	public DynaForm(String moduleId, String action, String mode) {
		super(moduleId, action, mode);
		this.model = new ModuleModel();
	}

	@Override
	protected boolean customValidation() {
		return true;
	}

	/**
	 * @param attributeName
	 * @param attributeValue
	 * @return
	 * @see com.irtve.portal.core2.module.model.ModuleModel#addAttribute(java.lang.String,
	 *      java.lang.Object)
	 */
	public Model addAttribute(String attributeName, Object attributeValue) {
		return model.addAttribute(attributeName, attributeValue);
	}

	/**
	 * @param attributeName
	 * @return
	 * @see com.irtve.portal.core2.module.model.ModuleModel#containsAttribute(java.lang.String)
	 */
	public boolean containsAttribute(String attributeName) {
		return model.containsAttribute(attributeName);
	}

	/**
	 * @param arg0
	 * @return
	 * @see java.util.LinkedHashMap#get(java.lang.Object)
	 */
	public Object get(Object arg0) {
		return model.get(arg0);
	}

	/**
	 * @return
	 * @see java.util.HashMap#keySet()
	 */
	public Set<String> keySet() {
		return model.keySet();
	}

	/**
	 * @return
	 * @see java.util.HashMap#values()
	 */
	public Collection<Object> values() {
		return model.values();
	}

}
