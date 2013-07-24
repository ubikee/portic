package com.ubikee.portic.core.module.container.spring;

import org.springframework.context.annotation.ComponentScanSpec;
import org.springframework.context.annotation.Feature;
import org.springframework.context.annotation.FeatureConfiguration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Controller;

import com.ubikee.portic.core.module.annotation.Module;


/**
 * Spring AnnotationConfigApplicationContext Features Configuration Bean.
 * 
 * @author ernesto
 *
 */
@FeatureConfiguration
public class PortalFeatures {

	/**
	 * @return ComponentScanSpec for {@link Module} annotated beans.
	 */
	@Feature
	public ComponentScanSpec moduleScan() {
		return new ComponentScanSpec("com.ubikee.portic.module").
			includeFilters(new AnnotationTypeFilter(Module.class)).
			excludeFilters(new AnnotationTypeFilter(Controller.class));
	}
}