document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.LoginApi = {
	loginApi: function(url, data, success) {
		window.TimUtil.postJson(url, data, function(data) {
			if(success) success(data)
		}) 
	},
	validatePhoneApi: function(url, data, success) {
		window.TimUtil.postJson(url ,data, function(data) {
			if (success) success(data)
		})
	},
	validateCodeApi: function(url, data, success) {
		window.TimUtil.postJson(url ,data, function(data) {
			if (success) success(data)
		})
	},
	registerApi: function(url, data, success) {
		window.TimUtil.postJson(url ,data, function(data) {
			if (success) success(data)
		})
	}
}
