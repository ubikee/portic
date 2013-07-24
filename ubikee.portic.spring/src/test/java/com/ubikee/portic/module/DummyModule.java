package com.ubikee.portic.module;

import com.ubikee.portic.core.Model;
import com.ubikee.portic.core.module.GenericModule;
import com.ubikee.portic.core.module.ModuleConfig;
import com.ubikee.portic.core.module.annotation.Module;
import com.ubikee.portic.core.module.annotation.ModuleAction;
import com.ubikee.portic.core.module.annotation.ModuleMode;
import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleActionNotFoundException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.model.ModuleModel;


@Module
public class DummyModule extends GenericModule<DummyForm> {

	public DummyForm createForm() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getModuleUID() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ModuleConfig arg0) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.irtve.portal.core2.module.Module#process(com.irtve.portal.core2.Form,
	 * java.lang.String)
	 */
	public Model process(DummyForm arg0, String arg1) throws InvalidFormException, ModuleModeNotFoundException, ModuleActionNotFoundException {
		System.out.println(this.getClass().getName());
		return null;
	}
	
	@ModuleAction("action1")
	public void doAction1(DummyForm form, ModuleModel model) {
		// do nothing
	}

	@ModuleMode(ModuleMode.VIEW)
	public void doView(ModuleModel model) {
		// do nothing
	}
}
