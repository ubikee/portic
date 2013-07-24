package com.ubikee.portic.core.module.events;

import java.util.List;

/**
 * 
 * @author ernesto
 *
 */
public interface ModuleEventHandler {

	/**
	 * 
	 * @param events
	 */
	void handle(List<ModuleEvent> events);
}
