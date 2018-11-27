class SingleChatSnapshot {
	constructor(meId, sideId, content, isRead) {
	    this.meId = meId
	    this.sideId = sideId
	    this.content = content
	    this.isRead = isRead
	}
}

class GroupChatSnapshot {
	constructor(meId, groupId, content, isRead) {
	    this.meId = meId
	    this.groupId = groupId
	    this.content = content
	    this.isRead = isRead
	}
}

window.cacheChatSnapshot = {
	chatSnapshotReadType: {
		YesRead: true,	// 我发送的
		NoRead: false	// 对方其他人发送的
	},
	/**
	 * 保存聊天快照
	 * 删除相同快照
	 * 添加新的快照
	 * @param {Object} meId
	 * @param {Object} sideId
	 * @param {Object} content
	 * @param {Object} isRead 是否已读
	 */
	setSingleChatSnapshot: function(meId, sideId, content, isRead) {
		var self = this
		var singleSnapshotKey = 'singleSnapshot_' + meId
		var singleSnapshotList = self.getSingleChatSnapshot(meId)
		if (singleSnapshotList.length > 0) {
			for (var i = 0; i < singleSnapshotList.length; i++) {
				if (singleSnapshotList[i].sideId == sideId) {
					singleSnapshotList.splice(i, 1)
					break
				}
			}
		}
		var singleChatSnapshot = new SingleChatSnapshot(meId, sideId, content, isRead)
		singleSnapshotList.unshift(singleChatSnapshot)
		plus.storage.setItem(singleSnapshotKey, JSON.stringify(singleSnapshotList))
		
	},
	getSingleChatSnapshot: function(meId) {
		var self = this
		var singleSnapshotKey = 'singleSnapshot_' + meId
		var singleSnapshotListStr = plus.storage.getItem(singleSnapshotKey)
		var singleSnapshotList
		if (self.isNotNull(singleSnapshotListStr)) {
			singleSnapshotList = JSON.parse(singleSnapshotListStr)
		} else {
			singleSnapshotList = []
		}
		return singleSnapshotList
	},
	updateReadSingleChatSnapshot: function(meId, sideId) {
		var self = this
		var singleSnapshotKey = 'singleSnapshot_' + meId
		var singleSnapshotList = self.getSingleChatSnapshot(meId)
		if (singleSnapshotList.length > 0) {
			for (var i = 0; i < singleSnapshotList.length; i++) {
				if (singleSnapshotList[i].sideId == sideId) {
					singleSnapshotList[i].isRead = window.cacheChatSnapshot.chatSnapshotReadType.YesRead
					singleSnapshotList.splice(i, 1, singleSnapshotList[i])
					break
				}
			}
			plus.storage.setItem(singleSnapshotKey, JSON.stringify(singleSnapshotList))
		}
	},
	deleteSingleChatSnapshot: function(meId, sideId) {
		var self = this
		var singleSnapshotKey = 'singleSnapshot_' + meId
		var singleSnapshotList = self.getSingleChatSnapshot(meId)
		if (singleSnapshotList.length > 0) {
			for (var i = 0; i < singleSnapshotList.length; i++) {
				if (singleSnapshotList[i].sideId == sideId) {
					singleSnapshotList.splice(i, 1)
					break
				}
			}
			plus.storage.setItem(singleSnapshotKey, JSON.stringify(singleSnapshotList))
		}
	},
	setGroupChatSnapshot: function(meId, groupId, content, isRead) {
		var self = this
		var groupSnapshotKey = 'groupSnapshot_' + meId
		var groupSnapshotList = self.getGroupChatSnapshot(meId)
		if (groupSnapshotList.length > 0) {
			for (var i = 0; i < groupSnapshotList.length; i++) {
				if (groupSnapshotList[i].groupId == groupId) {
					groupSnapshotList.splice(i, 1)
					break
				}
			}
		}
		var groupChatSnapshot = new GroupChatSnapshot(meId, groupId, content, isRead)
		groupSnapshotList.unshift(groupChatSnapshot)
		plus.storage.setItem(groupSnapshotKey, JSON.stringify(groupSnapshotList))
	},
	getGroupChatSnapshot: function(meId) {
		var self = this
		var groupSnapshotKey = 'groupSnapshot_' + meId
		var groupSnapshotListStr = plus.storage.getItem(groupSnapshotKey)
		var groupSnapshotList
		if (self.isNotNull(groupSnapshotListStr)) {
			groupSnapshotList = JSON.parse(groupSnapshotListStr)
		} else {
			groupSnapshotList = []
		}
		return groupSnapshotList
	},
	updateReadGroupChatSnapshot: function(meId, groupId) {
		var self = this
		var groupSnapshotKey = 'groupSnapshot_' + meId
		var groupSnapshotList = self.getGroupChatSnapshot(meId)
		if (groupSnapshotList.length > 0) {
			for (var i = 0; i < groupSnapshotList.length; i++) {
				if (groupSnapshotList[i].groupId == groupId) {
					groupSnapshotList[i].isRead = window.cacheChatSnapshot.chatSnapshotReadType.YesRead
					groupSnapshotList.splice(i, 1, groupSnapshotList[i])
					break
				}
			}
			plus.storage.setItem(groupSnapshotKey, JSON.stringify(groupSnapshotList))
		}
	},
	deleteGroupChatSnapshot: function(meId, groupId) {
		var self = this
		var groupSnapshotKey = 'groupSnapshot_' + meId
		var groupSnapshotList = self.getGroupChatSnapshot(meId)
		if (groupSnapshotList.length > 0) {
			for (var i = 0; i < groupSnapshotList.length; i++) {
				if (groupSnapshotList[i].groupId == groupId) {
					groupSnapshotList.splice(i, 1)
					break
				}
			}
			plus.storage.setItem(groupSnapshotKey, JSON.stringify(groupSnapshotList))
		}
	},
	isNotNull: function(str) {
		if (str != null && str !='' && str != undefined) {
			return true
		}
		return false
	}
}
