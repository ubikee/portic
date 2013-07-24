package ubikee.messaging;

import ubikee.cqrs.Handler;
import ubikee.cqrs.MessageHandlingException;

public interface Bus {
	
    /**
     * Publishes a message to all subscribers.
	 * 
	 * @param channel
	 * @param message
	 * @throws MessageHandlingException an error occurred during message processing.
	 */
    void publish(String channel, Object message) throws MessageHandlingException;
    
    /**
     * Subscribe a handler to an channel
     * 
     * @param event
     * @param handler
     */
    void subscribe(String channel, Handler handler);


}