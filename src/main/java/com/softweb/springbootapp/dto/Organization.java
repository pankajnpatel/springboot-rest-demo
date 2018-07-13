package com.softweb.springbootapp.dto;

import io.swagger.annotations.ApiModelProperty;

public class Organization {

	public Organization(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@ApiModelProperty(notes = "The application-specific product name", required = true)
	private String name;

	@ApiModelProperty(notes = "The application-specific product description", required = true)
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
