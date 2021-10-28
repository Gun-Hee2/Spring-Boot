package mul.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.MemberDto;
import mul.com.a.service.MemberService;

@RestController // restful    @Controller + @ResponseBody
public class MemberController {

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(){
		System.out.println("MemberController test()");
		
		return "test";	// test.jsp가 아님!
	}
	
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public MemberDto getMember() {
		System.out.println("MemberController getMember()");
		MemberDto dto = new MemberDto("aaa", "111", "홍두께", "aaa", 3);
		return dto;
	}
	
	@RequestMapping(value = "/dbtest", method = RequestMethod.GET)
	public List<MemberDto> dbtest() {
		System.out.println("MemberController dbtest()");
		
		List<MemberDto> list = service.allMember();
		
		return list;
	}
	
	@RequestMapping(value = "/conn_param", method = RequestMethod.GET)
	public String conn_param(String title) {
		System.out.println("MemberController conn_param()");
		
		System.out.println("title:" + title);
		
		return "connection success";
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String account(MemberDto dto) {
		System.out.println("MemberController account()");
		System.out.println(dto.toString());
		
		return "성공";
		
	}
	
	@RequestMapping(value = "/addmember", method = RequestMethod.POST)
	public boolean addmember(MemberDto dto) {
		System.out.println("MemberController addmember()");
		
		boolean b = service.addMember(dto);
		
		return b;
	}
}





