package com.ubikee.portic.core.site.repository;

import org.junit.Test;

import com.ubikee.portic.core.site.Site;
import com.ubikee.portic.core.site.SiteFactory;
import com.ubikee.portic.core.site.repository.SiteRepository;


public class TestSiteRepository {

	SiteRepository repository;
	
	@Test
	public void testSave() {
		Site site = SiteFactory.createSite("Site1");
		repository.save(site);
	}
	
}
