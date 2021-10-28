package mul.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.TempDao;
import mul.com.a.dto.TempDto;

@Service
@Transactional
public class TempService {
	
	@Autowired
	TempDao dao;
	
	public List<TempDto> allTemp() {
		return dao.allTemp();
	}

}
