package com.izmo.core.forms.service;

import com.izmo.core.model.Forms;
import com.izmo.core.model.FormsId;

public interface FormsService {
	Forms getFormsById(FormsId formsId);
}
