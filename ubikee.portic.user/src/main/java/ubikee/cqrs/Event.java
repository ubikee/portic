package ubikee.cqrs;

/**
 * 
 * @author ernesto
 *
 */
public class Event {

	public final String name;
	public final Object entityID;
	
	/**
	 * 
	 * @param entityID
	 * @param name
	 */
	public Event(Object entityID, String name ) {
		this.entityID = entityID;
		this.name = name;
	}
	
}
