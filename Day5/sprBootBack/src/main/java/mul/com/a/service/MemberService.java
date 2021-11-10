package mul.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.MemberDao;
import mul.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberDao dao;
	
	public List<MemberDto> allMember() {
		return dao.allMember();
	}
	
	public boolean addMember(MemberDto dto) {
		int n = dao.addMember(dto);
		return n>0?true:false;
	}
	
	public MemberDto login(MemberDto mem) {
		return dao.login(mem);
	}
	
	public boolean idcheck(String id) {
		int n = dao.idcheck(id);
		return n>0?true:false;
	}
	
}
