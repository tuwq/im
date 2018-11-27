class SingleChatHistory {
	constructor(meId, sideId, content, flag, contentType) {
	    this.meId = meId
	    this.sideId = sideId
	    this.content = content
	    this.flag = flag
	    this.contentType = contentType
	}
}
class GroupChatHistory {
	constructor(meId, sender, groupId, content, flag, contentType) {
	    this.meId = meId
	    this.sender = sender
	    this.groupId = groupId
	    this.content = content
	    this.flag = flag
	    this.contentType = contentType
	}
}

window.cacheChatHistory = {
	chatHistoryFlagType: {
		contentForMe: 1,	// 我发送的
		contentForSide: 2	// 对方其他人发送的
	},
	chatHistoryContentType: {
		imageType: 'image',
		textType: 'text',
		byteType: 'byte'
	},
	/**
	 * 保存私聊记录
	 * @param {Object} meId
	 * @param {Object} sideId
	 * @param {Object} content
	 * @param {Object} flag 本条消息是我还是朋友发送的, 1: 我, 2:对方
	 */
	setSingleChatHistory: function(meId, sideId, content, flag, contentType) {
		var self = this
		var singleChatKey = 'singleChat_' + meId + "-" + sideId
		var singleChatHistoryList = self.getSingleChatHistory(meId, sideId)
		var singleChatHistory = new SingleChatHistory(meId, sideId, content, flag, contentType)
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
	setGroupChatHistory: function(meId, sender, groupId, content, flag, contentType) {
		var self = this
		var groupChatKey = 'groupChat_' + meId + "-" + groupId
		var groupChatHistoryList = self.getGroupChatHistory(meId, groupId)
		var groupChatHistory = new GroupChatHistory(meId, sender, groupId, content, flag, contentType)
		groupChatHistoryList.push(groupChatHistory)
		plus.storage.setItem(groupChatKey, JSON.stringify(groupChatHistoryList))
	},
	getGroupChatHistory: function(meId, groupId) {
		var self = this
		var groupChatKey = 'groupChat_' + meId + "-" + groupId
		var groupChatHistoryListStr = plus.storage.getItem(groupChatKey)
		var groupChatHistoryList
		if (self.isNotNull(groupChatHistoryListStr)) {
			groupChatHistoryList = JSON.parse(groupChatHistoryListStr)
		} else {
			groupChatHistoryList = []
		}
		return groupChatHistoryList
	},
	deleteGroupChatHistory: function(meId, groupId) {
		var groupChatKey = 'groupChat_' + meId + "-" + groupId
		plus.storage.removeItem(groupChatKey)
	},
	isNotNull: function(str) {
		if (str != null && str !='' && str != undefined) {
			return true
		}
		return false
	}
}
