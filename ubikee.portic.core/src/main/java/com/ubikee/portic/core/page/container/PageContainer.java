package com.ubikee.portic.core.page.container;

import com.ubikee.portic.core.PageRequestDispatcher;
import com.ubikee.portic.core.page.PageDescriptor;

/**
 * The page container handles page's life cycle.
 * 
 * @author ernesto
 *
 */
public interface PageContainer extends PageRequestDispatcher {

	void init();
	
	void destroy();
	
	PageDescriptor createPage();
	
	void configPage(PageDescriptor pageDescriptor);
	
}
