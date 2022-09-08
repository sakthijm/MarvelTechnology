package com.example.webapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
public class WebapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebapplicationApplication.class, args);
	}
			@GetMapping("/new")
			public String hello(@RequestParam(value="name",defaultValue="world")String name)
			{
				return String.format("Hello %s",name);
			}
	
            @GetMapping("/old")
            public ModelAndView old()
            {
            	ModelAndView ruba= new ModelAndView();
            	ruba.setViewName("index.html");
            	return ruba;
            }
            
            @RequestMapping("/index")
            public ModelAndView project()
            {
            	ModelAndView sakthi= new ModelAndView();
            	sakthi.setViewName("index.jsp");
            	return sakthi;
            }

}
