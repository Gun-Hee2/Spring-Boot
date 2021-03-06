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

}
