package com.ubikee.portic.core.page;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ubikee.portic.core.module.container.ModuleContainer;
import com.ubikee.portic.core.module.descriptor.ModuleDescriptor;
import com.ubikee.portic.core.module.events.ModuleEvent;
import com.ubikee.portic.core.module.events.ModuleEventHandler;
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
public class Page2 implements ModuleEventHandler {

	protected static final Log log = LogFactory.getLog(Page.class);
	
	private ModuleContainer moduleContainer;

	private PageDescriptor pageDescriptor;
	
	/**
	 * constructor.
	 * 
	 * @param config
	 */
	public Page2(PageDescriptor config) {
		this.pageDescriptor = config;
		moduleContainer.setModuleEventHandler(this);
	}

	/**
	 * 
	 * @param <FORM>
	 * @param form
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleModeNotFoundException
	 * @throws ModuleActionNotFoundException
	 */
	public <FORM extends Form> PageDescriptor process(FORM form) throws InvalidFormException, ModuleModeNotFoundException, ModuleActionNotFoundException {
		
		// process the module in action
		ModuleModel model1 = moduleContainer.processModule(form.getModuleId(), form);
		
		// process the modules already unprocessed
		for (ModuleDescriptor module : pageDescriptor.modules) {			
				ModuleModel model2 = moduleContainer.processModule(module.getId(), form);
		}
		
		return pageDescriptor;
	}
	
	@Override
	public void handle(List<ModuleEvent> events) {
		for (ModuleEvent event : events ) {

		}
	}

}
