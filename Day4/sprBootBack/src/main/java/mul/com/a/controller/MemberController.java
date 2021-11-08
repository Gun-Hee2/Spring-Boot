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
	
	@RequestMapping(value = "/addmember", method = RequestMethod.POST)
	public String addmember(MemberDto dto) {
		System.out.println("MemberController addmember()");
		
		boolean b = service.addMember(dto);
		
		if(b == true) {
			return "OK";
		}
		return "NG";
	}
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberController idcheck()");
		System.out.println("id:" + id);
		
		boolean b = service.idcheck(id);
		System.out.println(b);
		
		if(b == true) {
			return "YES";
		}else {
			return "NO";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(MemberDto mem) {
		System.out.println("MemberController login()");
		
		System.out.println(mem);
		
		
		MemberDto dto = service.login(mem);
		
		System.out.println(dto);
		
		return dto;
		
		/*
		  if(dto != null && dto.getId().equals("") == false) { return true; }else {
		  return false; }
		 */
		
	}
	
	
}





