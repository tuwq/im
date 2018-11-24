class SingleChatHistory {
	constructor(meId, sideId, content, flag) {
	    this.meId = meId
	    this.sideId = sideId
	    this.content = content
	    this.flag = flag
	}
}

window.cacheChatHistory = {
	chatHistoryFlagType: {
		contentForMe: 1,	// 我发送的
		contentForSide: 2	// 对方其他人发送的
	},
	/**
	 * 保存私聊记录
	 * @param {Object} meId
	 * @param {Object} sideId
	 * @param {Object} content
	 * @param {Object} flag 本条消息是我还是朋友发送的, 1: 我, 2:对方
	 */
	setSingleChatHistory: function(meId, sideId, content, flag) {
		var self = this
		var singleChatKey = 'singleChat_' + meId + "-" + sideId
		var singleChatHistoryList = self.getSingleChatHistory(meId, sideId)
		var singleChatHistory = new SingleChatHistory(meId, sideId, content, flag)
		singleChatHistoryList.push(singleChatHistory)
		plus.storage.setItem(singleChatKey, JSON.stringify(singleChatHistoryList))
	},
	getSingleChatHistory: function(meId, sideId) {
		var self = this
		var singleChatKey = 'singleChat_' + meId + "-" + sideId
		var singleChatHistoryListStr = plus.storage.getItem(singleChatKey)
		var singleChatHistoryList
		if (self.isNotNull(singleChatHistoryListStr)) {
			singleChatHistoryList = JSON.parse(singleChatHistoryListStr)
		} else {
			singleChatHistoryList = []
		}
		return singleChatHistoryList
	},
	deleteSingleChatHistory: function(meId, sideId) {
		var singleChatKey = 'singleChat_' + meId + "-" + sideId
		plus.storage.removeItem(singleChatKey)
	},
	isNotNull: function(str) {
		if (str != null && str !='' && str != undefined) {
			return true
		}
		return false
	}
}
