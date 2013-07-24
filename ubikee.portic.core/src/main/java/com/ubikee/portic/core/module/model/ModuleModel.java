package com.ubikee.portic.core.module.model;

import java.util.ArrayList;
import java.util.List;

import com.ubikee.portic.core.Model;
import com.ubikee.portic.core.module.descriptor.ModuleActionDescriptor;
import com.ubikee.portic.core.module.events.ModuleEvent;

/**
 * Model map
 * 
 * @author ernesto
 *
 */
@SuppressWarnings("serial")
public class ModuleModel extends Model {

	List<ModuleEvent> events;
	List<ModuleActionDescriptor> actions = new ArrayList<ModuleActionDescriptor>();
	
	/**
	 * Construct a new, empty <code>Model</code>.
	 */
	public ModuleModel() {
	}

	/**
	 * 
	 * @return
	 */
	public List<ModuleEvent> getEvents() {
		if (events == null)
			events = new ArrayList<ModuleEvent>();
		return events;
	}

	/**
	 * @param event
	 */
	public void addEvent(ModuleEvent event) {
		if (events == null)
			events = new ArrayList<ModuleEvent>();
		events.add(event);
	}
	
}
