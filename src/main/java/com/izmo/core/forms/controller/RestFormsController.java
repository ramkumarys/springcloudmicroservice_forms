package com.izmo.core.forms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.izmo.core.forms.service.FormsService;
import com.izmo.core.model.Forms;
import com.izmo.core.model.FormsId;

@RestController
public class RestFormsController {

	@Autowired
	FormsService formsService;

	@RequestMapping(value = "/api/v1/form")
	@Cacheable(value = "formview", key = "#formId", unless = "#result == null")
	public Forms getFormsById(@RequestParam(value = "formId") Integer formId) {

		return formsService.getFormsById(new FormsId(formId, 1033));
	}
}
