package com.ubikee.portic.core.module;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.ubikee.portic.core.module.exception.InvalidFormException;
import com.ubikee.portic.core.module.exception.ModuleModeNotFoundException;
import com.ubikee.portic.core.module.form.DynaForm;
import com.ubikee.portic.core.module.model.ModuleModel;

/**
 * 
 * @author ernesto
 * 
 */
public abstract class Mashup extends GenericModule<DynaForm> {

	String serviceURL = "";
	String viewName;

	/**
	 * 
	 * @param form
	 * @param mode
	 * @return
	 * @throws InvalidFormException
	 * @throws ModuleModeNotFoundException
	 */
	public ModuleModel process(DynaForm form) throws InvalidFormException {

		validateForm(form);

		ModuleModel model = new ModuleModel();

		invokeRemoteService(form, model);

		resolveView(model);

		return model;

	}

	/**
	 * 
	 * @param form
	 * @param model
	 */
	private void invokeRemoteService(DynaForm form, ModuleModel model) {
		try {

			URL url = generateURL(form);
			URLConnection urlConnection = url.openConnection();

			// printHeader(urlConnection);

			InputStream stream = urlConnection.getInputStream();

			String contentType = urlConnection.getContentType();
			if (contentType.contains(";")) {
				//TODO : de momento solo se queda con el primer content type
				contentType = contentType.substring(0, contentType.indexOf(";"));
			}
			model.addAttribute("Content-Type", contentType);

			if (contentType.equals("text/html")) {
				StringBuffer sb = readResponse(stream);
				model.addAttribute("output", sb.toString());
			} else if (contentType.equals("application/xml") || contentType.equals("text/xml")) {
				Document doc = parseResponse(stream);
				model.addAttribute("Document", doc);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param stream
	 * @throws IOException
	 */
	private StringBuffer readResponse(InputStream stream) throws IOException {
		StringBuffer sb = new StringBuffer();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
		String line = bufferedReader.readLine();
		while (line != null) {
			sb.append(line);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		return sb;
	}

	/**
	 * 
	 * @param form
	 * @return
	 * @throws IOException
	 */
	private URL generateURL(DynaForm form) throws IOException {

		StringBuilder sb = new StringBuilder(serviceURL);
		if (!form.keySet().isEmpty()) {
			sb.append("?");
			for (String attribute : form.keySet()) {
				sb.append(attribute + "=");
				sb.append(form.get(attribute).toString());
				sb.append("&");
			}
		}

		URL url = new URL(sb.toString());
		return url;
	}

	/**
	 * @param stream
	 * @return
	 */
	private Document parseResponse(InputStream stream) {
		DocumentBuilder db;
		try {
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = db.parse(stream);
			return document;
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param urlConnection
	 */
	private void printHeader(URLConnection urlConnection) {
		Map<String, List<String>> headers = urlConnection.getHeaderFields();
		Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
		for (Map.Entry<String, List<String>> entry : entrySet) {
			String headerName = entry.getKey();
			System.out.println("Header Name:" + headerName);
			List<String> headerValues = entry.getValue();
			for (String value : headerValues) {
				System.out.print("Header value:" + value);
			}
			System.out.println();
			System.out.println();
		}
	}

	/**
	 * 
	 * @return
	 */
	public DynaForm createForm() {
		return new DynaForm(this.getModuleUID(), "MASHUP", "MASHUP");
	}

	/**
	 * 
	 * @param mode
	 * @param model
	 */
	private void resolveView(ModuleModel model) {
		model.addAttribute("VIEW", getViewName());
	}

	/**
	 * @return the serviceURL
	 */
	public String getServiceURL() {
		return serviceURL;
	}

	/**
	 * @param serviceURL
	 *            the serviceURL to set
	 */
	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	/**
	 * @return the viewName
	 */
	public String getViewName() {
		return viewName;
	}

	/**
	 * @param viewName
	 *            the viewName to set
	 */
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
