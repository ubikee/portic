import com.rtve.portal.core2.spring.AnnotatedModuleContainer;

scenario "initialization", {
	
	 given "an Annotated Module Container", {
	 	moduleContainer = new AnnotatedModuleContainer();
	 }
	 
	 when "it inits", {
	 	moduleContainer.init();
	 }
	
	 then "it should detect al classes annotated with @Module" , {
	 	moduleContainer.modules().size().shouldBe(1);
	 }
}
