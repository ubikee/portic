package com.ubikee.portic.core;

import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.page.PageDescriptor;

/**
 * 
 * @author ernesto
 *
 */
public interface PageRequestDispatcher {

	/**
	 * 
	 * @param form
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleModeNotFoundException
	 * @throws ModuleActionNotFoundException
	 */
	<FORM extends Form> PageDescriptor process(FORM form) throws InvalidFormException, ModuleModeNotFoundException, ModuleActionNotFoundException;
	
}
