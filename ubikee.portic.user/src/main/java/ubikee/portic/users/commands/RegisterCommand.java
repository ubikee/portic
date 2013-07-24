package ubikee.portic.users.commands;

import org.apache.commons.lang.Validate;

/**
 * 
 * @author ernesto
 *
 */
public class RegisterCommand {

	public final String email;
	public final String password;
	
	/**
	 * 
	 * @param email
	 * @param password
	 */
	public RegisterCommand(String email, String password) {
		
		Validate.notNull(email);
		Validate.notNull(password);
		
		this.email = email;
		this.password = password;
	}
	
}
