package com.izmo.core.forms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izmo.core.forms.dao.FormsDAO;
import com.izmo.core.model.Forms;
import com.izmo.core.model.FormsId;

@Service
@Transactional(readOnly = true)
public class FormsServiceImpl implements FormsService {

	@Autowired
	private FormsDAO formsDAO;

	@Override
	public Forms getFormsById(FormsId formsId) {
		return formsDAO.getFormsById(formsId);
	}

}
