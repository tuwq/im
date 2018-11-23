package root.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import root.bean.JsonResult;
import root.param.EditMeInfoParam;
import root.param.UploadAvatarBaseParam;
import root.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@PostMapping("/uploadAvatarForBase")
	public JsonResult<String>  uploadAvatarForBase(@RequestBody UploadAvatarBaseParam param) {
		String newAddress = userService.uploadAvatarForBase(param);
		return JsonResult.<String>success(newAddress);
	}
	
	@PostMapping("/editMeInfo")
	public JsonResult<Void> editMeInfo(@RequestBody EditMeInfoParam param){
		userService.editMeInfo(param);
		return JsonResult.<Void>success();
	}
}
