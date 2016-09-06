package com.springbootfirst.system.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author wangqiao
 * 		   wangzhiziqiao@163.com	
 *
 */
@Target({ElementType.FIELD,ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)   
@Documented 
public @interface Like {
	 String desc() default "";
	 /**
	  * 0 %abc
	  * 1 abc%
	  * 2 %abc%
	  * @return
	  */
	 int position() default 0;
}
