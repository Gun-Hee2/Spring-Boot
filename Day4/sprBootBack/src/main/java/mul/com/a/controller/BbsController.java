package mul.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "/bbslist", method = RequestMethod.GET)
	public List<BbsDto> bbslist(BbsParam param){
		System.out.println("BbsController bbslist()");
		
		System.out.println(param);
		
		int sn = param.getPage();  // 0, 1, 2...
		int start = sn * 10 + 1;   // 1, 11, 21...
		int end = (sn + 1) * 10;   // 10, 20, 30...
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = service.getbbslist(param);
		
		return list;
		
	}
	
	// 글의 총수
	@RequestMapping(value = "/bbscount", method = RequestMethod.GET)
	public int bbscount(BbsParam param) {
		System.out.println("BbsController bbscount()");
		
		return service.getbbscount(param);
	}
	
	@RequestMapping(value = "/bbswrite", method = RequestMethod.POST)
	public String bbswrite(BbsDto bbs) {
		System.out.println("BbsController bbswrite()");
		
		boolean b = service.writeBbs(bbs);
		
		if(b == true) {
			return "YES";
		}
		
		return "NO";
	}
	
	@RequestMapping(value = "/bbsdetail", method = RequestMethod.GET)
	public BbsDto bbsdetail(int seq) {
		System.out.println("BbsController bbsdetail()");
		
		service.readcount(seq);
		
		BbsDto dto = service.getBbs(seq);
		
		return dto;
	}
	
	@RequestMapping(value = "/bbsanswer", method = RequestMethod.POST)
	public String bbsanswer(BbsDto dto) {
		System.out.println("BbsController bbsanswer()");
		
		//System.out.println(dto);
		
		boolean up = service.answerup(dto);
		
		
		
		boolean in = service.answerin(dto);
		
		if(in == true) {
			return "YES";
		}
		
		return "NO";
			
	}
	
	@RequestMapping(value = "/bbsupdate", method = RequestMethod.GET)
	public String bbsupdate(BbsDto dto) {
		System.out.println("BbsController bbsupdate()");
		
		System.out.println(dto);
		
		boolean b = service.updateBbs(dto);
		
		if(b == true) {
			return "YES";
		}
		
		return "NO";
		
	}
	
	@RequestMapping(value = "/bbsdelete", method = RequestMethod.GET)
	public String bbsdelete(BbsDto dto) {
		System.out.println("BbsController bbsdelete()");
		
		boolean b = service.deleteBbs(dto);
		
		if(b == true) {
			return "YES";
		}
		
		return "NO";
		
	}

}




