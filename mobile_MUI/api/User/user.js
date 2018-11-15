document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.userApi = {
	uploadAvatarApi: function(url, data, success){
		window.TimUtil.postUpload(url, data, function(data) {
			if(success) success(data)
		})
	},
	uploadBaseUrlAvatarApi: function(url ,data, success) {
		window.TimUtil.postJson(url, data, function(data) {
			if(success) success(data)
		}) 
	},
	editMeInfoApi: function(url, data, success) {
		window.TimUtil.postJson(url, data, function(data) {
			
			if(success) success(data)
		})
	}
}
