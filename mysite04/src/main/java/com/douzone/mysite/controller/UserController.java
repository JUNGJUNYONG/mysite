package com.douzone.mysite.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.mysite.service.UserService;
import com.douzone.mysite.vo.UserVo;
import com.douzone.security.Auth;
import com.douzone.security.AuthUser;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/join",method = RequestMethod.GET)
	public String join(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	@RequestMapping(value="/join",method = RequestMethod.POST)
	public String join(@ModelAttribute @Valid UserVo vo, BindingResult result,Model model) {
		if(result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println(error);
//			}
			model.addAllAttributes(result.getModel());
			return "user/join";
		}
		userService.join(vo);
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping("/joinsuccess")
	public String joinsucces() {
		return "user/joinsuccess";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String login() {
		System.out.println("login get");
		return "user/login";
	}
	
	/*
	 * @RequestMapping(value="/login",method = RequestMethod.POST) public String
	 * login(HttpSession session,UserVo vo) { System.out.println("login get");
	 * UserVo authUser = userService.getUser(vo); if(authUser == null) {
	 * System.out.println("Test1"); return "user/login"; }
	 * session.setAttribute("authUser", authUser); System.out.println("test2");
	 * return "redirect:/"; }
	 */
	
	/*
	 * @RequestMapping(value="/logout") public String logout(HttpSession session) {
	 * //////////////////접근제어////////////////// UserVo authUser =
	 * (UserVo)session.getAttribute("authUser"); if(authUser == null) { return
	 * "redirect:/"; } //////////////접근제어////////////////////////////
	 * session.removeAttribute("authUser"); session.invalidate(); return
	 * "redirect:/"; }
	 */
	
	@Auth
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String update(@AuthUser UserVo authUser,Model model) {
		Long no = authUser.getNo();
		UserVo vo = userService.getUser(no);
		model.addAttribute("userVo",vo);
		return "user/update";
	}
	
	@Auth
	@RequestMapping(value="/update",method=RequestMethod.POST)
		public String update(UserVo vo) {
		userService.update(vo);
		return "redirect:/user/update";
	}
	
	@RequestMapping(value="/auth",method = RequestMethod.POST)
	public void auth() {
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public void logout() {
	}
	
//	@ExceptionHandler( Exception.class)
	
//	public String handleException() {
//		return "error/exception";
	
//	}
	

}