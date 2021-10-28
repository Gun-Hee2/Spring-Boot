package mul.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.TempDto;

@Mapper
@Repository
public interface TempDao {
	
	List<TempDto> allTemp(); //temp.xml의 id값과 일치해야한다.

}
