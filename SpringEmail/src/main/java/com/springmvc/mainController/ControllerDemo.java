package com.springmvc.mainController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mail.MailProcessor.EmailProcessor;
import com.springmvc.user.UserInfo;

import mail.UserManager.UserOperations;

@Controller
public class ControllerDemo {
	
	private ApplicationContext con;
	
	@RequestMapping("/compose")
	public String compose(Model md)
	{
		md.addAttribute("user", new UserInfo());
		return "new";
	}
	
	@RequestMapping(value="/login")
	public String login(@RequestParam("username") String user, @RequestParam("password") String p, HttpServletRequest request, Model md)
	{	
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserOperations u=con.getBean(UserOperations.class);
		Boolean b=u.check(user, p);
		
		if(b)
		{
			HttpSession session=request.getSession();
			String Id=session.getId();
			session.setAttribute("id", Id);
			System.out.println(Id);
			md.addAttribute("message", "Logged in Successfully.");
			return "login";
		}
		else
		{
			md.addAttribute("message", "Incorrect username or password.");
			return "login";
		}
	}
	
	@RequestMapping("/send")
	public String send(@ModelAttribute("user") UserInfo u, Model md)
	{
		System.out.println(u.getEmail());
		
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		EmailProcessor p=con.getBean(EmailProcessor.class);
		md.addAttribute("message", p.sendEmail(u));
		
		return "new";
	}

}
