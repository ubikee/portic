package com.ubikee.portic.core.module.container;

import java.util.List;

import com.ubikee.portic.core.ModuleRequestDispatcher;
import com.ubikee.portic.core.module.Module;
import com.ubikee.portic.core.module.descriptor.ModuleDescriptor;
import com.ubikee.portic.core.module.events.ModuleEvent;
import com.ubikee.portic.core.module.events.ModuleEventHandler;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * The container is responsible of {@link Module}s life cycle.
 * 
 * @author ernesto
 * 
 */
public interface ModuleContainer extends ModuleRequestDispatcher {

	/**
	 * 
	 */
	void init();

	/**
	 * 
	 */
	void destroy();

	/**
	 * 
	 * @return
	 */
	List<ModuleDescriptor> modules();

	/**
	 * 
	 * @param moduleId
	 * @return
	 */
	<FORM extends Form> Module<FORM> getModule(String moduleId);
	
	/**
	 * 
	 * @param events
	 */
	void handleModuleEvents(List<ModuleEvent> events);

	/**
	 * 
	 * @return
	 */
	ModuleEventHandler getModuleEventHandler();
	
	/**
	 * 
	 * @param moduleEventHandler
	 */
	void setModuleEventHandler(ModuleEventHandler moduleEventHandler);
	
}