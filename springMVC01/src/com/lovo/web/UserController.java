package com.lovo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lovo.entity.User;

@Controller
@SessionAttributes("loginUser")
public class UserController {

	@RequestMapping(value = "login", method=RequestMethod.POST)
	public ModelAndView doLogin(User user){
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("loginUser", user);
		mav.setViewName("redirect:showgoods.do");
		return mav;
	}
	
	@RequestMapping("pub")
	public String pubTopic(@ModelAttribute("loginUser") User user){
		System.out.println(user.getUsername());
		
		return "redirect:showgoods.do";
	}
}
