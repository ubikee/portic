package com.ubikee.portic.core.spring;
import org.junit.Before;
import org.junit.Test;

import com.ubikee.portic.core.module.annotation.ModuleMode;
import com.ubikee.portic.core.module.container.ModuleContainer;
import com.ubikee.portic.core.module.container.spring.AnnotatedModuleContainer;
import com.ubikee.portic.module.DummyForm;

public class AnnotatedModuleContainerTest {

	ModuleContainer container;
	
	@Before
	public void setup() {
		this.container = new AnnotatedModuleContainer();
		this.container.init();
	}
	
	@Test
	public void test

	@Test
	public void testProcess() throws Exception {
		DummyForm form = new DummyForm("dummyModule", "action1", ModuleMode.VIEW);
		this.container.processModule("dummyModule", form);

		// this.container.module("dummyModule").process(form);
	}
}