package com.ubikee.portic.core.page.repository.spring;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.neo4j.rest.RestNode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ubikee.portic.core.page.Page;
import com.ubikee.portic.core.page.PageDescriptor;
import com.ubikee.portic.core.page.repository.PageRepository;

/**
 * 
 * @author ernesto
 * 
 */
public class PageRepositoryImpl implements PageRepository {

	private static final Log logger = LogFactory.getLog(PageRepository.class);
	
	String pageRepositoryPath = "";
	RestTemplate restTemplate;

	/**
	 * 
	 * @param path
	 */
	public PageRepositoryImpl(String path) {
		this.pageRepositoryPath = path;
		this.restTemplate = new RestTemplate();
	}

	public Page get(String id) {
		String result = restTemplate.getForObject( pageRepositoryPath + "/" + id, String.class);
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		RestNode node;
		try {
			HashMap<String,Object> untyped = mapper.readValue(result, HashMap.class);
			logger.debug(untyped.toString());
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Page> getAll() {
		// TODO Auto-generated method stub 
		return null;
	}

	public void saveOrUpdate(PageDescriptor pd) throws com.ubikee.portic.core.page.repository.PageRepositoryException{
		try {
			String result = restTemplate.getForObject(pageUrl(pd), String.class);
		} catch (HttpClientErrorException e) {
			PageNode node = new PageNode(pd.id, pd.view, pd.template, pd.skin, pd.errorPolicy);
			URI location = restTemplate.postForLocation(pageRepositoryPath, node);
			logger.debug("created a new page at "+location.toString());
		}
	}
	
	private URI pageUrl(PageDescriptor pageDescriptor) {
		try {
			URI url = new URI( pageRepositoryPath + "/pages/" + pageDescriptor.id);
			return url;
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
