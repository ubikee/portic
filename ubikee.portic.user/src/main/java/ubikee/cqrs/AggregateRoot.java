package ubikee.cqrs;

import java.util.UUID;

public class AggregateRoot extends Entity<UUID>{

	public AggregateRoot(UUID id) {
		super(id, new Aggregate(id));
	}

}
