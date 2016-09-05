package com.springbootfirst.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springbootfirst.returnData.Info;

@ControllerAdvice
public class GlobalExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public Info<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
		Info<String> r = new Info<String>();
		r.setMessage(e.getMessage());
		r.setCode(StatusConstant.ERROR);
		r.setData("你请求的地址为：" + req.getRequestURL().toString());
		return r;
	}
}
