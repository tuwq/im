document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.UserApi = {
	editMeInfoApi: function(data, success) {
		window.TimUtil.postJson('/user/editMeInfo', data, function(data) {
			if(success) success(data)
		})
	}
}
