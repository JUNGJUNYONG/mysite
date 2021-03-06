package com.douzone.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.mysite.action.main.MainActionFactory;
import com.douzone.mysite.action.user.UserActionFactory;
import com.douzone.web.action.Action;
import com.douzone.web.action.ActionFactory;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actionName = request.getParameter("a");
		if(actionName == null) {
			actionName = "  ";
		}
		Action action = new UserActionFactory().getAction(actionName);
		action.execute(request,response);
		/*
		 * if("joinform".equals(action)) {
		 * WebUtil.forward("/WEB-INF/views/user/joinform.jsp", request, response);
		 * }else if("join".equals(action)){
		 * WebUtil.forward("/WEB-INF/views/user/join.jsp", request, response); }else
		 * if("joinsucces".equals(action)){
		 * WebUtil.forward("/WEB-INF/views/user/joinsucces.jsp", request, response);
		 * }else { WebUtil.redirect(request.getContextPath(), request, response); }
		 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
