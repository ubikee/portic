package com.ubikee.portic.core;


/**
 * 
 * @author ernesto
 *
 */
public interface PortalContext {
	
	public void init();
	
	public void reload();
	
	public void destroy();
	
	public PageRequestDispatcher getPageRequestDispatcher(String pageID);
	
	public ModuleRequestDispatcher getModuleRequestDispatcher(String moduleID);

}
