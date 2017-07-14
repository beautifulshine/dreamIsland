package com.dreamIsland.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dreamIsland.dao.UserDao;
import com.dreamIsland.service.IUserService;

@Controller  
@RequestMapping("/user")  
public class DreamIslandController {

	 @Resource  
	    private IUserService userService;  
	      
	    @RequestMapping("/showUser")  
	    public String toIndex(HttpServletRequest request,Model model){  
	        int userId = Integer.parseInt(request.getParameter("id"));  
	        User user = this.userService.getUserById(userId);  
	        model.addAttribute("user", user);  
	        return "showUser";  
		
	}

	
	/*@Autowired
	protected UserDao userDao;
	@RequestMapping("/test")
	public void getUserInfo(HttpServletRequest request,HttpServletResponse response){
		int userId=Integer.parseInt(request.getParameter("userId"));
		User user=userDao.getUserById(userId);
		if(user!=null){
			request.setAttribute("user", user);
			System.out.println(user.getUserName());
		}else{
			System.out.println("user is not exists");
		}
		
		}*/
	
	

}
