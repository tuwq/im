package root.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Maps;

import root.bean.JsonResult;
import root.constant.ResultCode;
import root.exception.CheckParamException;
import root.model.User;
import root.mq.producer.TestProducer;
import root.mqbean.TestModel;
import root.redis.RedisOperator;
import root.service.TestService;
import root.util.JsonUtils;
import root.util.MD5Util;
import root.util.ThreadUtil;
import root.util.TimeAgoUtils;

@RestController
public class TestController {
	
	@Resource
	private TestService testService;
	
	@Resource
	private RedisOperator redis;
	
	@GetMapping("/all")
	public List<User> test() {
		return testService.all();
	}
	
	@GetMapping("/string")
	public JsonResult<String> string() {
		return JsonResult.<String>success("ok");
	}
	
	@GetMapping("/build")
	public JsonResult<User> build() {
		User user = User.builder().name("nickname").id(1).build();
		return JsonResult.<User>success(user);
	}
	
	@GetMapping("/json")
	public JsonResult<User> json() {
		User build = User.builder().name("nickname").id(1).build();
		String json = JsonUtils.objectToJson(build);
		System.out.println(json);
		User user = JsonUtils.jsonToPojo(json, User.class);
		return JsonResult.<User>success(user);
	}
	
	@GetMapping("exception")
	public JsonResult<Void> exception() {
		System.out.println(TimeAgoUtils.format(new Date()));
		System.out.println(MD5Util.encrypt("aaaa"));
		throw new CheckParamException("参数错误");
	}
	
	@GetMapping("/thread")
	public JsonResult<Void> thread() {
		System.out.println("use in controller.....start");
		System.out.println(ThreadUtil.getCurrentRequest());
		System.out.println(ThreadUtil.getCurrentResponse());
		System.out.println("use in controller.....end");
		testService.thread();
		return JsonResult.success();
	}
	
	@Resource
	private TestProducer testProducer;
	
	@GetMapping("/mq")
	public JsonResult<String> mq() {
		testProducer.TestModelsend(TestModel.builder().id("1").name("a1").messageId("100").build(), Maps.newHashMap());
		return JsonResult.<String>success("ok");
	}
}
