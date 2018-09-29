package root.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import root.model.User;

@Mapper
public interface TestMapper {

	public List<User> all();
}
