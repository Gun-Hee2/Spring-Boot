package mul.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	public List<MemberDto> allMember();
	
	boolean addMember(MemberDto dto);
}
