package com.ubikee.portic.core.module.form;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * This form is the input interface in a {@link Module} operation. The
 * {@link Module} should validate the form.
 * 
 * @author ernesto
 * 
 */
public abstract class Form {

	static final String VALID_MESSAGE = "This form is valid.";
	
	@NotEmpty
	String moduleId;
	
	@NotEmpty
	String action;

	@NotEmpty
	String mode;

	Validator validator;
	String validationMessage = VALID_MESSAGE;

	/**
	 * 
	 * @param moduleId
	 * @param action
	 * @param mode
	 */
	public Form(String moduleId, String action, String mode) {
		this.moduleId = moduleId;
		this.action = action;
		this.mode = mode;
	}
	
	/**
	 * Validate the form.
	 * 
	 * @return true if form is valid
	 */
	public boolean isValid() {
		return internalValidation() && customValidation();
	}

	/**
	 * Check fields annotated with JSR303 validation annotations
	 * 
	 * @param form
	 */
	private boolean internalValidation() {
		Set<ConstraintViolation<Form>> constraintViolations = getValidator().validate(this);
		boolean valid = constraintViolations.isEmpty();
		validationMessage = valid ? VALID_MESSAGE : errorMessage(constraintViolations);
		return valid;
	}

	/**
	 * Custom Validation. Form child class must override
	 * 
	 * @return true if form is valid
	 */
	protected abstract boolean customValidation();

	/**
	 * 
	 * @return
	 */
	private Validator getValidator() {
		if (this.validator == null) {
			ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
			this.validator = factory.getValidator();
		}
		return validator;
	}

	/**
	 * 
	 * @return String with a valid form message
	 */
	public String getValidationMessage() {
		return validationMessage;
	}

	/**
	 * 
	 * @return String with an invalid form message
	 */
	public String errorMessage(Set<ConstraintViolation<Form>> constraintViolations) {
		StringBuffer sb = new StringBuffer();
		sb.append("[ ");
		for (ConstraintViolation<Form> cv : constraintViolations) {
			sb.append("ConstraintViolation { ");
			sb.append(cv.getMessage());
			sb.append(";\n");
		}
		sb.append("]");

		return "ConstraintViolations = " + constraintViolations;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the mode
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * @param mode
	 *            the mode to set
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * @return the moduleId
	 */
	public String getModuleId() {
		return moduleId;
	}

	/**
	 * @param moduleId the moduleId to set
	 */
	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}
}
