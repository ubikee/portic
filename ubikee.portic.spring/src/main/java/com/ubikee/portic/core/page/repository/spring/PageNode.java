package com.ubikee.portic.core.page.repository.spring;


public class PageNode {

	public String id;
	public String view;
	public String template;
	public String skin;
	public String errorPolicy;

	/**
	 * 
	 */
	public PageNode() {}
	
	/**
	 * 
	 * @param id
	 * @param view
	 * @param template
	 * @param skin
	 * @param modules
	 * @param errorPolicy
	 */
	public PageNode(String id, String view, String template, String skin, String errorPolicy) {
		this.id = id;
		this.view = view;
		this.template = template;
		this.skin = skin;
		this.errorPolicy = errorPolicy;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the view
	 */
	public String getView() {
		return view;
	}

	/**
	 * @param view
	 *            the view to set
	 */
	public void setView(String view) {
		this.view = view;
	}

	/**
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * @param template
	 *            the template to set
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	/**
	 * @return the skin
	 */
	public String getSkin() {
		return skin;
	}

	/**
	 * @param skin
	 *            the skin to set
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}

	/**
	 * @return the errorPolicy
	 */
	public String getErrorPolicy() {
		return errorPolicy;
	}

	/**
	 * @param errorPolicy
	 *            the errorPolicy to set
	 */
	public void setErrorPolicy(String errorPolicy) {
		this.errorPolicy = errorPolicy;
	}

}
