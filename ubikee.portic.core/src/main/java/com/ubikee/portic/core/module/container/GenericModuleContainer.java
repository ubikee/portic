package com.ubikee.portic.core.module.container;

import java.util.List;

import com.ubikee.portic.core.module.Module;
import com.ubikee.portic.core.module.events.ModuleEvent;
import com.ubikee.portic.core.module.events.ModuleEventHandler;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * Abstract {@link ModuleContainer} implementation.
 * 
 * @author ernesto
 * 
 */
public abstract class GenericModuleContainer implements ModuleContainer {

	ModuleEventHandler moduleEventHandler;
	
	@Override
	public <FORM extends Form> ModuleModel processModule(String moduleId, FORM form) throws InvalidFormException, ModuleActionNotFoundException, ModuleModeNotFoundException {
		Module<FORM> module = getModule(moduleId);
		ModuleModel model = module.processAction(form.getAction(), form);
		handleModuleEvents(model.getEvents());
		module.processMode(form.getMode(), model);
		return model;
	}
	
	@Override
	public void handleModuleEvents(List<ModuleEvent> events) {
		ModuleEventHandler eventHandler = getModuleEventHandler();
		if (eventHandler != null) {
			eventHandler.handle(events);
		}
	}

	/* (non-Javadoc)
	 * @see com.irtve.portal.core2.module.container.ModuleContainer#getModuleEventHandler()
	 */
	@Override
	public ModuleEventHandler getModuleEventHandler() {
		return moduleEventHandler;
	}

	/* (non-Javadoc)
	 * @see com.irtve.portal.core2.module.container.ModuleContainer#setModuleEventHandler()
	 */
	@Override
	public void setModuleEventHandler(ModuleEventHandler moduleEventHandler) {
		this.moduleEventHandler = moduleEventHandler;
	}

}