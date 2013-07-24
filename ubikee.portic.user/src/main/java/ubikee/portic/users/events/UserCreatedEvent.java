package ubikee.portic.users.events;

import java.util.UUID;

import ubikee.cqrs.Event;

/**
 * 
 * @author ernesto
 *
 */
public class UserCreatedEvent extends Event {

	/**
	 * @constructor
	 * 
	 * @param id
	 * @param email
	 * @param password
	 */
	public UserCreatedEvent(UUID id, String email, String password) {
		super(id, UserCreatedEvent.class.getName());
	}

}
