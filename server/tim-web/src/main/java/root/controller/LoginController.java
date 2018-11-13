package root.controller;

import static org.hamcrest.CoreMatchers.sameInstance;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.dto.LoginDto;
import root.param.LoginParam;
import root.param.RegisterParam;
import root.param.ValidateParam;
import root.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	private LoginService loginService;
	
	/**
	 * 验证手机号并发送验证码
	 * @return
	 */
	@PostMapping("/validatePhone")
	public JsonResult<String> validatePhone(@RequestBody ValidateParam param) {
		String validateCode = loginService.validatePhone(param);
		return JsonResult.<String>success(validateCode) ;
	}
	
	@PostMapping("/validateCode")
	public JsonResult<Void> validateCode(@RequestBody ValidateParam param) {
		loginService.validateCode(param);
		return JsonResult.<Void>success();
	}
	
	@PostMapping("/register")
	public JsonResult<Void> register(@RequestBody RegisterParam param) {
		loginService.register(param);
		return JsonResult.<Void>success();
	}
	
	@PostMapping("/login")
	public JsonResult<LoginDto> login(@RequestBody LoginParam param) {
		LoginDto loginDto = loginService.login(param);
		return JsonResult.<LoginDto>success(loginDto);
	}
}
