package com.ubikee.portic.core.site;

import java.util.UUID;


/**
 * @author ernesto
 *
 */
public class SiteFactory {

	/**
	 * @param name
	 * @return
	 */
	public static Site createSite(String name) {
		UUID id = UUID.randomUUID();
		Site site = new Site(id);
		site.setName(name);
		return site;
	}

}
