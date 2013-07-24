package ubikee.portic.users.commands.handlers;

import ubikee.portic.users.aggregates.User;
import ubikee.portic.users.aggregates.UserFactory;
import ubikee.portic.users.commands.RegisterCommand;
import ubikee.portic.users.repository.UsersRepository;

/**
 * User Commands Handler.
 * 
 * @author ernesto
 *
 */
public class UserCommandHandler {

	private UsersRepository repository;
	
	/**
	 * @constructor
	 * 
	 * @param repository
	 */
	public UserCommandHandler(UsersRepository repository) {
		this.repository = repository;
	}
	
	/**
	 * 
	 * @param command
	 * @return
	 * @throws Throwable
	 */
	public Object handleRegisterCommand(RegisterCommand command) throws Throwable {
		UserFactory userFactory = new UserFactory();
		User user = userFactory.create(command.email, command.password);
		repository.save(user);
		return Void.TYPE;
	}
	
}