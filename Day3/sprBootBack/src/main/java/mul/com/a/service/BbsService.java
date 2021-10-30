package mul.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {
	
	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getbbslist(BbsParam param) {
		return dao.getbbslist(param);
	}
	
	public int getbbscount(BbsParam param) {
		return dao.getbbscount(param);
	}
	
	public boolean writeBbs(BbsDto bbs) {
		return dao.writeBbs(bbs);
	}
	
	public void readcount(int seq) {
		dao.readcount(seq);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean answerup(BbsDto dto) {
		return dao.answerup(dto);
	}
	
	public boolean answerin(BbsDto dto) {
		return dao.answerin(dto);
	}
	
	public boolean updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}
	
	public boolean deleteBbs(BbsDto dto) {
		return dao.deleteBbs(dto);
	}

}
