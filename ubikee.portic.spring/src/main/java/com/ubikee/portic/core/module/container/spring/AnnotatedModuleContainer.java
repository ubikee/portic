package com.ubikee.portic.core.module.container.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ubikee.portic.core.module.annotation.Module;
import com.ubikee.portic.core.module.container.GenericModuleContainer;
import com.ubikee.portic.core.module.container.ModuleContainer;
import com.ubikee.portic.core.module.descriptor.ModuleDescriptor;
import com.ubikee.portic.core.module.form.Form;

/**
 * This is the {@link ModuleContainer} implementation for annotated modules. It
 * scans the classpath detecting every bean annotated with {@link @Module}
 * annotation.
 * 
 * @author ernesto
 * 
 */
public class AnnotatedModuleContainer extends GenericModuleContainer {

	private static final Log logger = LogFactory.getLog(AnnotatedModuleContainer.class);

	ApplicationContext ctx;

	List<ModuleDescriptor> modules = new ArrayList<ModuleDescriptor>();
	
	@Override
	public void init() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("\nUBIKEE.PORTIC.CORE.SPRING\n");
		sb.append("Starting Container: AnnotatedModuleContainer...\n");
		sb.append("Scanning @Module anotations... \n");
		logger.info(sb.toString());
		
		ctx = new AnnotationConfigApplicationContext(PortalConfig.class, PortalFeatures.class);
		Map<String, Object> modules = ctx.getBeansWithAnnotation(Module.class);
		for (String name : modules.keySet()) {
			ModuleDescriptor md = new ModuleDescriptor(name, name, "", true, null );
			this.modules.add(md);
		}
		
		sb = new StringBuffer();
		sb.append("Detected Modules: \n");
		int counter = 1;
		for (ModuleDescriptor md : this.modules) {
			sb.append(counter + " : " + md.getName() + " ");
			counter++;
		}
		logger.info(sb.toString());
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public List<ModuleDescriptor> modules() {
		return modules;
	}

	public <FORM extends Form> com.ubikee.portic.core.module.Module<FORM> getModule(String moduleId) {
		@SuppressWarnings("unchecked")
		com.ubikee.portic.core.module.Module<FORM> mod = ctx.getBean(moduleId, com.ubikee.portic.core.module.Module.class);
		return mod;
	}
	
}