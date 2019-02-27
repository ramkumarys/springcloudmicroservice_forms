package com.izmo.services.formbuilder.boot;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.izmo.core.module.listvalues.dao.ListValuesRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormBuilderApplicationTests {

	
	@Autowired
	ListValuesRepository listValueRepository;
	
	@Test
	public void contextLoads() {
		Map<String,Object> levelMap=new HashMap<>();
		listValueRepository.listValuesByGroupKey(levelMap, "ParSMS", 1036);
	}

}
