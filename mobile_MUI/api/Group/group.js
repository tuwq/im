document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.GroupApi = {
	createGroupApi: function(data, success) {
		window.TimUtil.postJson('/group/create', data, function(data) {
			if(success) success(data)
		}) 
	},
	groupMemberListApi: function(data, success) {
		window.TimUtil.getJson('/group/memberList', data, function(data) {
			if(success) success(data)
		})
	},
	groupListByJoinedApi: function(data, success) {
		window.TimUtil.getJson('/group/listByUserId', data, function(data) {
			if(success) success(data)
		})
	}
}
