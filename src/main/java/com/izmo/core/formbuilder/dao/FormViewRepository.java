package com.izmo.core.forms.dao;

import org.springframework.data.repository.CrudRepository;

import com.izmo.core.model.Forms;
import com.izmo.core.model.FormsId;

public interface FormsDAO extends CrudRepository<Forms, FormsId>{

	Forms getFormsById(FormsId formsId);
}
