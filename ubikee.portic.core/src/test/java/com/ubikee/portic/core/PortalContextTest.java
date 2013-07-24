package com.ubikee.portic.core;

import java.awt.print.PageFormat;

import org.junit.Assert;

import com.ubikee.portic.core.module.form.DynaForm;
import com.ubikee.portic.core.module.form.Form;

public class PortalContextTest {

	PortalContext portalContext;
	
	public void shouldProcessPageRequest() throws Exception {

		PageRequestDispatcher pageRequestDispatcher = portalContext.getPageRequestDispatcher("page1");
		
		Form form = new DynaForm("page1", null, null);
		
		pageRequestDispatcher.process(form);
	}
}
