package com.ubikee.portic.core.module;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;

import com.ubikee.portic.core.module.annotation.ModuleAction;
import com.ubikee.portic.core.module.annotation.ModuleMode;
import com.ubikee.portic.core.module.events.ModuleEvent;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * Abstract {@link Module} implementation..
 * 
 * @author ernesto
 * 
 * @param <FORM>
 */
public abstract class GenericModule<FORM extends Form> implements Module<FORM> {

	/**
	 * Module Config
	 */
	ModuleConfig config;

	/**
	 * 
	 */
	Map<String, String> views = new HashMap<String, String>();

	@Override
	public abstract FORM createForm();

	@Override
	public ModuleModel processAction(String action, FORM form) throws InvalidFormException, ModuleActionNotFoundException {
		validateForm(form);
		ModuleModel model = new ModuleModel();
		invokeActionMethod(action, form, model);
		return model;
	}

	@Override
	public ModuleModel processMode(String mode, ModuleModel model) throws ModuleModeNotFoundException {
		invokeModeMethod(mode, model);
		return model;
	}

	@Override
	public void launchEvent(ModuleEvent event, ModuleModel model) {
		model.addEvent(event);
	}

	/**
	 * Validate Form.
	 * 
	 * @param form
	 * @throws InvalidFormException
	 */
	protected void validateForm(FORM form) throws InvalidFormException {
		try {
			Validate.notNull(form);
			if (!form.isValid()) {
				throw new InvalidFormException(form.getValidationMessage());
			}
		} catch (IllegalArgumentException e) {
			throw new InvalidFormException("The form cannot be null");
		}
	}

	/**
	 * 
	 * @param form
	 * @param mode
	 * @param model
	 * @throws ModuleActionNotFoundException
	 */
	private void invokeActionMethod(String action, FORM form, ModuleModel model) throws ModuleActionNotFoundException {

		try {

			for (Method m : getClass().getMethods()) {
				if (m.isAnnotationPresent(ModuleAction.class)) {
					ModuleAction modeAnnotation = m.getAnnotation(ModuleAction.class);
					if (modeAnnotation.value().equals(action)) {
						m.invoke(this, form, model);
						model.addAttribute("ACTION", action);
						return;
					}
				}
			}

			throw new ModuleActionNotFoundException("Action not found : " + action);

		} catch (InvocationTargetException e) {
			// TODO
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @param mode
	 * @param model
	 * @throws ModuleModeNotFoundException
	 */
	private void invokeModeMethod(String mode, ModuleModel model) throws ModuleModeNotFoundException {

		if (mode == null || mode.isEmpty()) {
			mode = ModuleMode.VIEW;
		}

		try {
			for (Method m : getClass().getMethods()) {
				if (m.isAnnotationPresent(ModuleMode.class)) {
					ModuleMode modeAnnotation = m.getAnnotation(ModuleMode.class);
					if (modeAnnotation.value().equals(mode)) {
						m.invoke(this, model);
						model.addAttribute("MODE", mode);
						return;
					}
				}
			}

			throw new ModuleModeNotFoundException("Mode not found : " + mode);

		} catch (InvocationTargetException e) {
			// TODO
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		resolveModeView(mode, model);
	}

	/**
	 * 
	 * @param mode
	 * @param model
	 */
	private void resolveModeView(String mode, ModuleModel model) {
		String viewName = views.get(mode);
		model.addAttribute("VIEW", viewName);
	}

}
