package ubikee.portic.users.listeners;

import ubikee.cqrs.Event;
import ubikee.cqrs.EventHandler;
import ubikee.messaging.Bus;
import ubikee.messaging.BusChannelListener;

/**
 * 
 * @author ernesto
 *
 */
public class AppChannelListener extends BusChannelListener {

	/**
	 * 
	 * @param bus
	 * @param channel
	 */
	public AppChannelListener(Bus bus, String channel) {
		super(bus, channel);
	}

	@EventHandler(name="event.app.users.userCreated")
	public void onRegisteredUser(Event event) {
		
		//RegisterCommand registerCommand = new RegisterCommand("","");
		
		
	}

	public void handleMessage(String message) {
		// TODO Auto-generated method stub
		
	}
	
}
