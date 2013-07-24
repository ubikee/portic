package com.ubikee.portic.core.module;

import com.ubikee.portic.core.module.events.ModuleEvent;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * A Module is a business facade that handles several modes and actions.
 * 
 * @param <FORM>
 *            The module provides a Form bean as input data interface.
 */
public interface Module<FORM extends Form> {

	/**
	 * 
	 * @param config
	 */
	void init(ModuleConfig config);

	/**
	 * 
	 * @return
	 */
	FORM createForm();

	/**
	 * 
	 * @return
	 */
	String getModuleUID();

	/**
	 * 
	 * @param form
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleActionNotFoundException
	 */
	ModuleModel processAction(String action, FORM form) throws InvalidFormException, ModuleActionNotFoundException;

	/**
	 * 
	 * @param form
	 * @param mode
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleModeNotFoundException
	 */
	ModuleModel processMode(String mode, ModuleModel model) throws ModuleModeNotFoundException;

	/**
	 * During processAction or processMode phases, the module can invoke this
	 * method in order to generate a broadcast event. The event is stored in the
	 * response Model and will be handled by the ModuleContainer.
	 * 
	 * @param event
	 * @param model
	 */
	void launchEvent(ModuleEvent event, ModuleModel model);
	
}
