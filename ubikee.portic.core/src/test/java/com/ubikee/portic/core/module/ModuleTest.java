package com.ubikee.portic.core.module;

import org.junit.Assert;
import org.junit.Test;

import com.ubikee.portic.core.module.annotation.ModuleAction;
import com.ubikee.portic.core.module.annotation.ModuleMode;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.Form;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * 
 * @author ernesto
 *
 */
public class ModuleTest {
	
	@Test(expected=ModuleModeNotFoundException.class)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAction1InvalidMode() throws Exception {
		GenericModule module = new TestModule();
		String action1 = "ACTION1";
		TestForm form = new TestForm("testModule", action1, ModuleMode.VIEW);
		module.processMode("UNDEFINED", module.processAction(action1,form));
	}
	
	@Test()
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAction1ModeView() throws Exception {
		GenericModule module = new TestModule();
		TestForm form = new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		String action1 = "ACTION1";
		form.setAction(action1);
		ModuleModel model = module.processAction(action1, form);
		module.processMode(ModuleMode.VIEW, model);
		
		Assert.assertEquals(ModuleMode.VIEW, model.get("MODE"));
		Assert.assertEquals("OK", model.get(action1));
	}
		
	/**
	 * 
	 * @author ernesto
	 *
	 */
	class TestModule extends GenericModule<Form> {

		@Override
		public void init(ModuleConfig config) {
			// TODO Auto-generated method stub
		}
		
		@ModuleMode(ModuleMode.VIEW)
		public void doView(ModuleModel model) {
			model.addAttribute("MODE", "VIEW");
		}

		@ModuleAction("ACTION1")
		public void doAction1(Form form, ModuleModel model) {
			model.addAttribute("ACTION1", "OK");
		}
		
		@Override
		public Form createForm() {
			return new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		}

		@Override
		public String getModuleUID() {
			return "testModule";
		}
	}
	
	/**
	 * 
	 * @author ernesto
	 *
	 */
	class TestForm extends Form {

		public TestForm(String moduleId, String action, String mode) {
			super(moduleId, action, mode);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected boolean customValidation() {
			return true;
		}
	}
}
