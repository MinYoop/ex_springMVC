package com.hello.mvc02;

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

import com.hello.mvc02.dto.CustomerDto;
import com.hello.mvc02.model.biz.CustomerBIz;
import com.hello.mvc02.model.biz.CustomerBizImpl;

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

	// ---------------------------------------------------
	@Autowired
	private CustomerBIz biz;

	@RequestMapping(value = "/list.do")
	public String list(Model model) {
		model.addAttribute("list", biz.selectAll());
		return "list";
	}

	@RequestMapping(value = "/index.do")
	public String index() {
		// 모델엔 뷰쓰기?
		return "index";
	}

	@RequestMapping(value = "/detail.do")
	public String detail(Model model, String id) {
//		System.out.println("detail"+">>"+id);
		model.addAttribute("dto", biz.selectOne(id));
		return "detail";
	}

	@RequestMapping(value = "/delete.do")
	public String delete(Model model, String id) {
		int res = biz.delete(id);

		if (res > 0) {
			System.out.println("삭제 성공");
			model.addAttribute("list", biz.selectAll());
			return "list";
		}else {
			System.out.println("삭제 실패");
			model.addAttribute("dto", biz.selectOne(id));
			return "detail";
		}
	}
	@RequestMapping(value="/insert.do")
	public String insert() {
		return "insert";
	}
	@RequestMapping(value="/insertAction.do")
	public String insertAction(Model model, CustomerDto dto ) {
		int res=biz.insert(dto);
		
		if (res > 0) {
			model.addAttribute("msg","삽입성공");
			model.addAttribute("url","list.do");
			return "alert";
		}else {
			model.addAttribute("msg","삽입실패");
			
			return "insert";
		}
	}
	@RequestMapping(value="/update.do")
	public String update(Model model, CustomerDto dto) {
		System.out.println("update테스트"+dto.getId());
		
		model.addAttribute("dto",dto);
		return "update";
	}
	@RequestMapping(value="/updateAction.do")
	public String updateAction(Model model, CustomerDto dto) {
		System.out.println(dto.getId());
		
		int res=biz.update(dto);
		
		if (res > 0) {
			model.addAttribute("msg","수정성공");
			model.addAttribute("url","detail.do?id="+dto.getId());
			return "alert";
		}else {
			model.addAttribute("msg","수정실패");
			model.addAttribute("url","detail.do?id="+dto.getId());
			return "alert";
		}
	}
}
