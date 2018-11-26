document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.GroupChatMsgApi = {
	getNoReadChatMsgListApi: function(data, success) {
		window.TimUtil.getJson('/chatMsg/group/getNoReadChatMsgList', data, function(data) {
			if(success) success(data)
		})
	}
}
