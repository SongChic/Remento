package com.Remento.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Remento.Model.TestModel;
import com.Remento.Model.User;
import com.Remento.Service.UserService;

import junit.framework.Test;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
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
	
	@RequestMapping(value="/join")
	public ModelAndView join(
			HttpServletRequest request, HttpServletResponse response
			) {
		
		ModelAndView mav = new ModelAndView("/user/join");
		
		return mav;
	}
	
	@RequestMapping( value="/joinProc" )
	public RedirectView joinProc (
			@RequestParam ( value = "userId" ) String userId,
			@RequestParam ( value = "userPw" ) String userPw,
			@RequestParam ( value = "userName" ) String userName,
			@RequestParam ( value = "userEmail" ) String userEmail,
			@RequestParam ( value = "zipCode" ) String zipCode,
			@RequestParam ( value = "adress" ) String adress,
			@RequestParam ( value = "etcAdress" ) String etcAdress,
			HttpServletRequest request, HttpServletResponse response
			) {
		
		User user = new User();
		user.setUserId(userId);
		user.setUserPw(userPw);
		user.setUserName(userName);
		user.setUserEmail(userEmail);
		user.setZipCode(zipCode);
		user.setAdress(adress);
		user.setEtcAdress(etcAdress);
		
		int req = userService.joinProc(user);
		
		
		System.out.println( "pass" );
		
		RedirectView rv = new RedirectView("");
		
		return rv;
	}
}
