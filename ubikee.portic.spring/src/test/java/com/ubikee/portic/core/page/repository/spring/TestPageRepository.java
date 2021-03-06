package com.ubikee.portic.core.page.repository.spring;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.ubikee.portic.core.module.descriptor.ModuleDescriptor;
import com.ubikee.portic.core.page.PageDescriptor;
import com.ubikee.portic.core.page.repository.PageRepository;
import com.ubikee.portic.core.page.repository.spring.PageRepositoryImpl;

/**
 * 
 * @author ernesto
 * 
 */
public class TestPageRepository {

	PageRepository pageRepository;

	@Before
	public void setup() {
		pageRepository = new PageRepositoryImpl("http://localhost:7474/db/data/node");
		BasicConfigurator.configure();
	}

	@Test
	public void testGet() throws Exception {
		String id = "12";
		pageRepository.get(id);
	}

	public void testGetAll() {
	}

	@Test
	public void testCreate() throws Exception {
		PageDescriptor pd = new PageDescriptor("page1", "page1", "template1", "skin1", new ArrayList<ModuleDescriptor>(), "NOT_FOUND");
		pageRepository.saveOrUpdate(pd);
	}

}
