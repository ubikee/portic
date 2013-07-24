package com.ubikee.portic.core;

import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * 
 * @author ernesto
 *
 */
public interface ModuleRequestDispatcher {

	/**
	 * 
	 * @param moduleId
	 * @param form
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleActionNotFoundException
	 * @throws ModuleModeNotFoundException
	 */
	<FORM extends Form> ModuleModel processModule(String moduleId, FORM form) throws InvalidFormException, ModuleActionNotFoundException, ModuleModeNotFoundException;
	
}
