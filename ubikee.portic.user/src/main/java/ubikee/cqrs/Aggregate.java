package ubikee.cqrs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Aggregate {

	public UUID versionID;

	private final Map<Object, Entity<?>> entities;

	private List<Event> unsavedEvents;

	/**
	 * @constructor
	 * 
	 * @param id
	 */
	public Aggregate(UUID id) {
		this.versionID = id;
		this.entities = new HashMap<Object, Entity<?>>();
		this.unsavedEvents = new ArrayList<Event>();
	}

	/**
	 * 
	 * @param event
	 */
	protected void apply(Event event) {
		Entity<?> entity = entities.get(event.entityID);
		entity.onEvent(event);
		unsavedEvents.add(event);
	}

	/**
	 * 
	 * @param entity
	 */
	public void add(Entity<?> entity) {
		entities.put(entity.id, entity);
	}

}
