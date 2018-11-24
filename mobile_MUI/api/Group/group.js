document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.GroupApi = {
	createGroupApi: function(data, success) {
		window.TimUtil.postJson('/group/create', data, function(data) {
			if(success) success(data)
		}) 
	}
}
