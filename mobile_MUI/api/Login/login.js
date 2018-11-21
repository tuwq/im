document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.LoginApi = {
	loginApi: function(data, success) {
		window.TimUtil.postJson('/login/login', data, function(data) {
			if(success) success(data)
		}) 
	},
	validatePhoneApi: function(data, success) {
		window.TimUtil.postJson('/login/validatePhone' ,data, function(data) {
			if (success) success(data)
		})
	},
	validateCodeApi: function(data, success) {
		window.TimUtil.postJson('/login/validateCode' ,data, function(data) {
			if (success) success(data)
		})
	},
	registerApi: function(data, success) {
		window.TimUtil.postJson('/login/register' ,data, function(data) {
			if (success) success(data)
		})
	}
}
