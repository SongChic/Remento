package com.Remento.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Remento.Model.TestModel;
import com.Remento.Security.SecurityProvider;
import com.Remento.Service.TestService;

@Controller
public class HomeController {
	@Autowired
	TestService testService;
	
	@RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
	public ModelAndView home( 
			HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session ) {
		
//		if ( session.getAttribute("user") == null ) {
//			return new ModelAndView("redirect:/login");
//		}
//		
		List<Map<String, Object>> test = testService.test();
////		int test = 0;
		
		ModelAndView mav = new ModelAndView("/index");
		mav.addObject("test", test);
		return mav;
	}
	
	@RequestMapping(value="/home")
	public ModelAndView testHome(
			HttpServletRequest request,
			HttpServletResponse response
			) {
		ModelAndView mav = new ModelAndView("/home");
		
		return mav;
	}
	@RequestMapping(value="/join")
	public ModelAndView join(
			HttpServletRequest request,
			HttpServletResponse response
			) {
		ModelAndView mav = new ModelAndView("/user/join");
		
		return mav;
	}
	
}
