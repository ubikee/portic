package ubikee.cqrs;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 
 * @author ernesto
 * 
 * @param <ID>
 */
public class Entity<ID> {

	public final ID id;
	protected final Aggregate aggregate;

	/**
	 * 
	 * @param id
	 * @param aggregate
	 */
	public Entity(ID id, Aggregate aggregate) {
		this.id = id;
		this.aggregate = aggregate;
		this.aggregate.add(this);
	}
	
	/**
	 * 
	 * @param event
	 */
	protected void apply(Event event) {
		aggregate.apply(event);
	}
	
	/**
	 * TODO: REFACTOR!!!!!!
	 * 
	 * @param event
	 */
	public void onEvent(Event event) {
		for (Method method : this.getClass().getMethods()) {
			if (method.isAnnotationPresent(EventHandler.class)) {
				Annotation annotation = method.getAnnotation(EventHandler.class);
				if(annotation instanceof EventHandler){
					EventHandler eventHandler = (EventHandler) annotation;
					String eventName = eventHandler.name();
					if (eventName.equals("ALL") || event.name.equals(eventName)) {
						try {
							method.invoke(this,event);
						} catch (Throwable ex) {
							System.out.printf("Test %s failed: %s %n", method,	ex.getCause());
						}
					}
				}
			}
		}
	}
}