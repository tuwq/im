document.write("<script language=javascript src='../../common/js/TimUtil.js'></script>");
window.SingleChatMsgApi = {
	getNoReadChatMsgListApi: function(data, success) {
		window.TimUtil.getJson('/chatMsg/single/getNoReadChatMsgList', data, function(data) {
			if(success) success(data)
		})
	}
}
