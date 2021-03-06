package com.ubikee.portic.core.module.descriptor;

import java.util.List;

/**
 * Module Descriptor Bean
 * 
 * @author ernesto
 *
 */
public class ModuleDescriptor {

	private String id;
	private String name;
	private String description;
	private boolean active;
	private List<ModuleActionDescriptor> actions;
	
	/**
	 * @constructor
	 * 
	 * @param id
	 * @param name
	 * @param desc
	 */
	public ModuleDescriptor(String id, String name, String desc, boolean active, List<ModuleActionDescriptor> actions) {
		this.id = id;
		this.name = name;
		this.description = desc;
		this.active = active;
		this.actions = actions;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the actions
	 */
	public List<ModuleActionDescriptor> getActions() {
		return actions;
	}
	
	
}
