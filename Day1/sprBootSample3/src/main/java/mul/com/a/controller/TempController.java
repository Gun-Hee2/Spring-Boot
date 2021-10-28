package mul.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.TempDto;
import mul.com.a.service.TempService;

@RestController
public class TempController {
	
	@Autowired
	TempService service;
	
	@RequestMapping(value = "alltemp", method = RequestMethod.GET)
	public List<TempDto> allTemp(){
		System.out.println("TempController allTemp()");
		
		return service.allTemp();
	}

}
