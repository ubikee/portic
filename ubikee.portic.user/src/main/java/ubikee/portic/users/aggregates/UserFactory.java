package ubikee.portic.users.aggregates;

import java.util.UUID;

/**
 * 
 * @author ernesto
 *
 */
public class UserFactory {

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	public User create(String email, String password) {
		
		//TODO: Validations
		
		return new User(UUID.randomUUID(), email, password);
		
	}
}
