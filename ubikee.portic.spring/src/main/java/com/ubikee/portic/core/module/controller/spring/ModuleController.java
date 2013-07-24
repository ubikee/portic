package com.ubikee.portic.core.module.controller.spring;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubikee.portic.core.Model;
import com.ubikee.portic.core.module.container.ModuleContainer;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;

/**
 * 
 * @author ernesto
 *
 * @param <FORM>
 */
public class ModuleController<FORM extends Form> {

	@Autowired
	private ModuleContainer moduleContainer;
	
	/**
	 * 
	 * @param form
	 * @param mode
	 */
	protected Model processModule(FORM form, String mode) {
		try {
			
			moduleContainer.processModule(form.getModuleId(), form);
			
		} catch (InvalidFormException e) {
			//TODO
			e.printStackTrace();
		} catch (ModuleModeNotFoundException e) {
			//TODO
			e.printStackTrace();
		} catch (ModuleActionNotFoundException e) {
			//TODO
			e.printStackTrace();
		}
		return null;
	}
	
}