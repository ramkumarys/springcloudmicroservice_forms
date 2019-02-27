package com.izmo.services.formbuilder.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.izmo.core.formbuilder.dto.WebFormDTO;
import com.izmo.core.module.formbuilder.service.FormsBuilderService;

@RestController
@RequestMapping(value = "/formbuilder/api/v1/")
public class RestFormBuilderController {

	@Autowired
	FormsBuilderService formsService;

	@RequestMapping(value = "form")
	public WebFormDTO getFormTemplateById(@RequestParam(value = "formId") Integer formId,
			@RequestParam(value = "dealerId") Integer dealerId) throws JsonParseException, JsonMappingException, IOException {

		return formsService.getForm(dealerId, formId);
	}
}
