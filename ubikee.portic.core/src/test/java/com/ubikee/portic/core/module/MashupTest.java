package com.ubikee.portic.core.module;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.ubikee.portic.core.module.form.DynaForm;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * 
 * @author ernesto
 * 
 */
@Ignore
public class MashupTest {

	/**
	 * 
	 */
	@Test
	@Ignore
	public void testInvoke() throws Exception {

		Mashup mashup = new Mashup() {

			@Override
			public void init(ModuleConfig config) {
			}

			@Override
			public String getModuleUID() {
				return this.getClass().getSimpleName();
			}
		};

		String url = "http://www.pre.rtve.es/beta/alacarta/interno/programpop.shtml";
		mashup.setServiceURL(url);

		DynaForm form = new DynaForm(mashup.getModuleUID(),"MASHUP","MASHUP");
		form.addAttribute("channel", "la1");
		form.addAttribute("numPrograms", 4);

		ModuleModel model = mashup.process(form);

		Assert.assertEquals("text/html", model.get("Content-Type"));
		System.out.println(model.get("output"));
	}

}
