package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	//회원가입
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		user.setUserType("CUS");
		int result = userService.saveUser(user);
		
		System.out.println("회원가입 처리 결과 : " + result);
		
		if(result > 0) {
			return "redirect:/main";
		} else {
			return "customer/signup";			
		}
	}
	
	@GetMapping("/customer/login")
	public String login() {
		return "customer/login";
	}
	
	@PostMapping("/customer/login")
	public String loginAction(User user) {
		
		//user id pw 화면으로부터 전달
		//name userType : null
		
		//user 로그인 할 수 있게 정보가 들어있는지 확인!
		
		return "customer/login";
	}
}
	
