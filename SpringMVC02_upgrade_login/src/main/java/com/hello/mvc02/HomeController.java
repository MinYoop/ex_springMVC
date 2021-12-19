package com.hello.mvc02;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hello.mvc02.dto.CustomerDto;
import com.hello.mvc02.model.biz.CustomerBiz;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	// ----------------------------------------------------------------------------------------------------------
	@Autowired
	private CustomerBiz biz;

	@RequestMapping(value = "/list.do")
	public String list(Model model) {

		model.addAttribute("list", biz.selectList());
		return "list";

	}

	@RequestMapping(value = "/loginform.do")
	public String loginform() {
		return "loginform";
	}
	
	@RequestMapping(value="/loginajax.do", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Boolean> loginAjax(String id, @RequestParam("pw")/*pw로 받은걸 password로 넣어주겠다*/ String password, HttpSession session){
		//@ResponseBody : java 객체를 response 객체에 binding 시켜서  response // map객체는 view resolver를 넘어뛰고 request에 실어서 간다.
		
		
		CustomerDto dto = biz.login(id,  password);
		
		boolean loginChk = false;
		
		if(dto!=null) {
			session.setAttribute("loginDto", dto);
			loginChk = true;
		}
		
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("lc", loginChk);
		return map;
		
	}
}
