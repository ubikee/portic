package com.ubikee.portic.core.page;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ubikee.portic.core.module.GenericModule;
import com.ubikee.portic.core.module.Module;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * Page
 * 
 * @author ernesto
 * 
 */
public class Page<FORM extends Form> {

	protected static final Log log = LogFactory.getLog(Page.class);

	private List<GenericModule<?>> modules;
	
	private PageDescriptor config;
	
	/**
	 * constructor.
	 * 
	 * @param config
	 */
	public Page(PageDescriptor config) {
		this.config = config;
	}
	
	/**
	 * @param result
	 * @param form
	 * 
	 */
	public ModuleModel process(FORM form) throws InvalidFormException {

		validateForm(form);

		ModuleModel model = new ModuleModel();

		processModules(form, model);

		model.addAttribute("VIEW", config.view);
		
		return model;

	}

	/**
	 * Validate PageForm.
	 * 
	 * @param form
	 * @throws InvalidFormException
	 */
	private void validateForm(FORM form) throws InvalidFormException {
		if (!form.isValid()) {
			throw new InvalidFormException(form.getValidationMessage());
		}
	}

	/**
	 * Call to every module controller with their respective form and model
	 * beans.
	 * 
	 * @param pageForm
	 * @param pageModel
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void processModules(FORM pageForm, ModuleModel pageModel) {

//		for (GenericModule module : modules) {
//			
//			// TODO: get module mode from ????
//			
//			try {
//				
//				Form moduleForm = moduleMappingForm(module, pageForm);
//				Model model = module.process(moduleForm, ModuleMode.VIEW);
//				pageModel.addAttribute(module.getModuleUID(), model);
//				
//			} catch (ModuleModeNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (InvalidFormException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (ModuleActionNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
//		}
		
	}

	/**
	 * 
	 * @param module
	 * @param pageForm
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private Form moduleMappingForm(Module<FORM> module, FORM pageForm) {
		Form form = module.createForm();
		try {
			BeanUtils.copyProperties(pageForm, form);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return form;
	}
	
}
