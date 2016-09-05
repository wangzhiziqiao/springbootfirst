package com.dcits;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.velocity.VelocityEngineUtils;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SzytApplicationTests {

	@Autowired  
	VelocityEngine velocityEngine;  
	  
	@Test  
	public void velocityTest(){  
	    Map<String, Object> model = new HashMap<String, Object>();  
	    model.put("time", new Date());  
	    model.put("message", "这是测试的内容。。。");  
	    model.put("toUserName", "张三");  
	    model.put("fromUserName", "老许");  
	    System.out.println(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "sys/po.vm", "UTF-8", model));  
	}  
}
