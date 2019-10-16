package com.controllerdemo;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Student;
import model.StudentDao;

@Controller
public class Controllerdemo {
	
	@Autowired
	private ApplicationContext con;
	
	@RequestMapping("/login")
	public String loginr()
	{
		return "login";
	}
	
	@RequestMapping("/register")
	public String Register(Model m)
	{
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		Student obj=con.getBean("std", Student.class);
		m.addAttribute("bean", obj);
		return "register";
	}
	
	@RequestMapping(value="/store", method=RequestMethod.POST)
	//Here @Valid annotation will apply the validation to the particular element of the bean object and BindingResult will bind the data
	public String store( @Valid @ModelAttribute("bean") Student s,BindingResult br, Model md )
	{
		if(br.hasErrors())
		{
			return "register";
		}
		else
		{
			con=new ClassPathXmlApplicationContext("applicationContext.xml");
			StudentDao obj=con.getBean("dao", StudentDao.class);
			
			try
			{
				obj.save(s);
				md.addAttribute("msg", "Data Inserted Successfully!");
				return "register";
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
				md.addAttribute("msg", "Error occured while saving data, Please check your enteries.");
				return "register";
			}
			
			
		}
	}
	
	@RequestMapping("/usercheck")
	public String auth( @RequestParam("user") String user, @RequestParam("pass") String pass, HttpSession session, Model md)
	{
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao obj=con.getBean("dao", StudentDao.class);
		Student st=new Student();
		st.setUsername(user);
		st.setPassword(pass);
		Boolean b=obj.login(st);
		
		if(b)
		{
			md.addAttribute("message", "Logged in successfully.");
			session.setAttribute("flag", st);
			return "login";
		}
		
		md.addAttribute("message","Incorrect Username or password.");
		return "login";
	}
	
	@RequestMapping(value="/display")
	public String view(Model m)
	{
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao st=con.getBean("dao", StudentDao.class);
		List list= st.display();
		m.addAttribute("data", list);
		
		return "display";
	}
	
	@RequestMapping(value="/update")
	public String update()
	{
		return "update";
	}
	
	@RequestMapping(value="/check")
	public String check(@RequestParam("id") int id, Model md)
	{
		con=new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao st=con.getBean("dao", StudentDao.class);
		
		List list= st.findbyID(id);
		
		md.addAttribute("data",list);
		
		if(list.isEmpty())
		{
			md.addAttribute("msg", "Not Found any student with ID="+id);
			
		}
		
		return "update";
	}
	

}
