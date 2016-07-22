package com.Remento.Controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import javax.activation.MailcapCommandMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.Remento.Model.TestModel;
import com.Remento.Model.User;
import com.Remento.Security.SecurityProvider;
import com.Remento.Service.TestService;
import com.Remento.Service.UserService;

@Controller
public class HomeController {
	@Autowired
	TestService testService;
	
	String mail = "";
	
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
	public ModelAndView home( 
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session ) {
		
		ModelAndView mav = new ModelAndView("/index");
		return mav;
	}
	
	@RequestMapping(value="/home")
	public ModelAndView testHome(
			HttpServletRequest request, HttpServletResponse response
			) {
		ModelAndView mav = new ModelAndView("/home");
		
		return mav;
	}
	
}
