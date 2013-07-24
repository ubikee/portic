package com.ubikee.portic.core.site;

import java.util.UUID;

public class Site {

	private UUID id;
	private String name;

	public Site(UUID id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
}
