document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.RequestApi = {
	requestSingleSendApi: function(data, success) {
		window.TimUtil.postJson('/request/single/send', data, function(data) {
			if(success) success(data)
		}) 
	},
	singleRequestAcceptApi: function(data, success) {
		window.TimUtil.getJson('/request/single/accept', data, function(data) {
			if(success) success(data)
		})
	},
	singleRequestAgree: function(data, success) {
		window.TimUtil.postJson('/request/single/agree', data, function(data) {
			if(success) success(data)
		})
	},
	singleRequestRefuse: function(data, success) {
		window.TimUtil.postJson('/request/single/refuse', data, function(data) {
			if(success) success(data)
		})
	},
	requestGroupJoinApi: function(data, success) {
		window.TimUtil.postJson('/request/group/join', data, function(data) {
			if(success) success(data)
		})
	}
}
