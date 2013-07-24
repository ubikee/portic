package com.ubikee.portic.module;

import com.ubikee.portic.core.module.form.Form;


public class DummyForm extends Form {

	public DummyForm(String moduleId, String action, String mode) {
		super(moduleId, action, mode);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected boolean customValidation() {
		// TODO Auto-generated method stub
		return true;
	}

}
