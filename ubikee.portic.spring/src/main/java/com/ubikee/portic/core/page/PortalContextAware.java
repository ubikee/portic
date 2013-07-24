package com.ubikee.portic.core.page;

import org.springframework.beans.factory.annotation.Autowired;

import com.ubikee.portic.core.PortalContext;

/**
 * 
 * @author ernesto
 *
 */
public class PortalContextAware {

	@Autowired
	PortalContext portalContext;

	public PortalContext getPortalContext() {
		return portalContext;
	}
	
}
