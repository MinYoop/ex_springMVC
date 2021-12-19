package com.hello.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// TODO : 05.biz(@Service) 호출
		@Autowired
		public HelloBiz biz;
		
		//TODO : 04. controller (hello.ho 찾아옴)
		@RequestMapping("/hello.do")
		public String getHello(Model model) {		
			
			//TODO : 09. 리턴받은 값을 Model에 담기
			//ModelAndView
			model.addAttribute("message",biz.getHello());
			
			return "hello";
		}
		
		@RequestMapping("/bye.do")
		public ModelAndView getBye(@RequestParam("name")String name) { //name이라는 request파라미터를 string name에 넣어줌

			ModelAndView mav = new ModelAndView();
			
			mav.setViewName("tmp/bye");
			mav.addObject("message", "Bye, " + name);		
			return mav;
		}
	
	@RequestMapping(value = "/home.do" , method = RequestMethod.GET)//get방식으로 넘어온다!
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	
}
