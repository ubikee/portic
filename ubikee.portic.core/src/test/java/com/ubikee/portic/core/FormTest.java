package com.ubikee.portic.core;

import org.hibernate.validator.constraints.NotEmpty;
import org.junit.Assert;
import org.junit.Test;

import com.ubikee.portic.core.module.annotation.ModuleMode;
import com.ubikee.portic.core.module.form.Form;

/**
 * FormTest
 * 
 * @author ernesto
 * 
 */
public class FormTest {

	@Test
	public void detectsValidForm() {
		TestForm form = new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		form.setName("John");
		Assert.assertTrue(form.isValid());
	}

	@Test
	public void detectsInvalidForm() {
		TestForm form = new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		Assert.assertTrue(!form.isValid());
	}
	
	@Test
	public void detectInvalidForm2() {
		TestForm form = new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		form.setName("Peter");
		Assert.assertTrue(!form.isValid());
	}
	
	@Test
	public void returnValidationMessage() {
		TestForm form = new TestForm("testModule", "ACTION1", ModuleMode.VIEW);
		Assert.assertTrue(!form.getValidationMessage().isEmpty());
	}

	/**
	 * 
	 * @author ernesto
	 *
	 */
	class TestForm extends Form {

		/**
		 * 
		 * @param moduleId
		 * @param action
		 * @param mode
		 */
		public TestForm(String moduleId, String action, String mode) {
			super(moduleId, action, mode);
		}

		@NotEmpty
		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		protected boolean customValidation() {
			return name.equals("John");
		}
	}
}