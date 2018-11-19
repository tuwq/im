document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.RequestApi = {
	requestSingleSendApi: function(url, data, success) {
		window.TimUtil.postJson(url, data, function(data) {
			if(success) success(data)
		}) 
	},
	requestSingleAcceptApi: function(url , data, success) {
		window.TimUtil.getJson(url, data, function(data) {
			if(success) success(data)
		})
	}
}
