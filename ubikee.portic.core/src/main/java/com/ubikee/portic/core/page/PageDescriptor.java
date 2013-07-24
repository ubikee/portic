package com.ubikee.portic.core.page;

import java.util.List;

import com.ubikee.portic.core.module.descriptor.ModuleDescriptor;

/**
 * Inmutable page descriptor bean.
 * 
 * @author ernesto
 * 
 */
public class PageDescriptor {

	public String id;
	public String view;
	public String template;
	public String skin;
	public List<ModuleDescriptor> modules;
	public String errorPolicy;
	
	/**
	 * 
	 * @param id
	 * @param view
	 * @param template
	 * @param skin
	 * @param modules
	 * @param errorPolicy
	 */
	public PageDescriptor(String id, String view, String template, String skin, List<ModuleDescriptor> modules, String errorPolicy) {
		this.id = id;
		this.view = view;
		this.template = template;
		this.skin = skin;
		this.modules = modules;
		this.errorPolicy = errorPolicy;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @return the modules
	 */
	public List<ModuleDescriptor> getModules() {
		return modules;
	}

	/**
	 * @return the errorPolicy
	 */
	public String getErrorPolicy() {
		return errorPolicy;
	}
	
}
