package root.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import root.mapper.TestMapper;
import root.model.User;
import root.util.ThreadUtil;

@Service
public class TestService {
	
	@Resource
	private TestMapper testMapper;
	
	public List<User> all() {
		return testMapper.all();
	}

	public void thread() {
		System.out.println("use in service.....start");
		System.out.println(ThreadUtil.getCurrentRequest());
		System.out.println(ThreadUtil.getCurrentResponse());
		System.out.println("use in service.....end");
	}
	
}
