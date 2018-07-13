package com.softweb.springbootapp.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softweb.springbootapp.dto.Organization;
import com.softweb.springbootapp.dto.PagedResult;
import com.softweb.springbootapp.dto.Product;

@RestController
@Api(value = "onlinestore", description = "Operations to get information about Organization", tags = {"1"})
public class OrgController {

	@Autowired
	private Environment env;

	@ApiOperation(value = "View roganization details", response = PagedResult.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list", response = Product.class),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	
	@RequestMapping(value = "/org/{id}/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public PagedResult<Organization> getMessage(
			@PathVariable(name = "id") String id,
			@RequestParam(name = "name") String name) {

		List<Organization> employees = new ArrayList<Organization>();
		employees.add(new Organization(env.getProperty("app.user.name"), "9510583381"));
		return new PagedResult<Organization>(employees, employees.size(), 0, 10);
		
	}
}