package com.dreamIsland.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dreamIsland.model.User;
import com.dreamIsland.service.IUserService;


@Controller  
@RequestMapping("user")  
public class DreamIslandController {

	 	@Resource  
	    private IUserService userService; 
	      
	    @RequestMapping("showUser")  
	    public ModelAndView toIndex(Integer userId){  
	        User user = userService.getUserById(userId);  
	        
	        return new ModelAndView("user","user",user);  
		
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
