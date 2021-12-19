package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.model.HelloBiz;

@Controller
public class HelloController {
	
	// TODO : 05.biz(@Service) 호출
	@Autowired
	public HelloBiz biz;
	
	//TODO : 04. controller (hello.ho 찾아옴)
	@RequestMapping("/hello.ho")
	public String getHello(Model model) {		
		
		//TODO : 09. 리턴받은 값을 Model에 담기
		//ModelAndView
		model.addAttribute("message",biz.getHello());
		
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/bye.ho")
	public ModelAndView getBye(@RequestParam("name")String name) { //name이라는 request파라미터를 string name에 넣어줌 //name과 name 이름 같으면 리퀘스트파라미터 어토테이션 생략가능
		//public ModelAndView getBye(String name)

		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "Bye, " + name);		
		return mav;
	}
}


/*
@RequestMapping
	RequestMapping Annotation은 url을 class 또는 method와 Mapping 시켜주는 역할을 한다. annotation을 쓰지 않을 때 지정하던, controller 등록을 위한 url bean 설정을 생략할 수 있다.

@RequestParam
	RequestParam annotation은 key=value 형태로 화면에서 넘어오는 파라미터를 맵핑된 메서드의 파라미터로 지정해 준다 주로 get 방식으로 들어오는 request에서 사용한다.
	
@ModelAttribute
	ModelAttribute Annotation은 화면에 form 속성으로 넘어온 model을 맵핑된 method의 파라미터로 지정해주는 역할을 한다.
	주로 post 타입으로 넘어오는 form 속성의 model값을 받아올 때 사용한다. (get/post모두 사용 가능)
*/
