package ubikee.portic.users.aggregates;

import java.util.UUID;

import ubikee.cqrs.AggregateRoot;
import ubikee.portic.users.events.UserCreatedEvent;

/**
 * 
 * @author ernesto
 *
 */
public class User extends AggregateRoot {

	UUID id;
	String email;
	String password;
	
	/**
	 * 
	 * @param id
	 * @param email
	 * @param password
	 */
	public User(UUID id, String email, String password) {
		super(id);
		apply(new UserCreatedEvent(id, email, password));
	}
	
}
