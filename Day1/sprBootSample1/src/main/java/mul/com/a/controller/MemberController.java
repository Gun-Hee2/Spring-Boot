package mul.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.service.MemberService;

@RestController // restful방식일 때 사용, @Controller + @ResponseBody
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception{
		System.out.println("MemberController test()");
		
		return "test";  // test.jsp가 아님!
	}

}
