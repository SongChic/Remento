package com.Remento.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Remento.Model.TestModel;

import junit.framework.Test;

@Controller
public class UserController {
	
	@RequestMapping(value="/login", method={RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login (
			@RequestParam(value="logout", required=false) String state,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView();
		if ( state != null ) {
			session.invalidate();
			return new ModelAndView("redirect:/");
		} else {
			mav.setViewName("/user/login");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/loginSuccess")
	public ModelAndView loginSuccess(
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session ) {
		TestModel model = (TestModel) SecurityContextHolder.getContext().getAuthentication().getDetails();
		session.setAttribute("user", model);
		return new ModelAndView("redirect:/");
	}
}
