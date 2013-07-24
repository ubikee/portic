package ubikee.messaging;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import ubikee.cqrs.Event;
import ubikee.cqrs.EventHandler;
import ubikee.cqrs.Handler;

/**
 * 
 * @author ernesto
 * 
 */
public abstract class BusChannelListener implements Handler {

	protected Bus bus;

	/**
	 * @constructor
	 * @param bus
	 * @param channel
	 */
	public BusChannelListener(Bus bus, String channel) {
		this.bus = bus;
		bus.subscribe(channel, this);
	}

	/**
	 * 
	 */
	public String getMessageType() {
		return null;
	}

	/**
	 * 
	 * @param message
	 */
	public void handleMessage(Event message) {
		
		for (Method method : this.getClass().getMethods()) {
			if (method.isAnnotationPresent(MessageHandler.class)) {
				
				Annotation annotation = method.getAnnotation(EventHandler.class);
				
				if (annotation instanceof MessageHandler) {
					MessageHandler messageHandler = (MessageHandler) annotation;
					String messageName = messageHandler.name();
					if (messageName.equals("ALL") || message.name.equals(messageName)) {
						try {
							method.invoke(this, message);
						} catch (Throwable ex) {
							System.out.printf("Method invocation %s failed: %s %n", method, ex.getCause());
						}
					}
				}
				
			}
		}
	}
	
	
	

}
