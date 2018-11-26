window.cacheGroupList = {
	getGroupItem: function(groupId) {
		var self = this
		var groupList = self.getGroupList()
		for (var i = 0; i < groupList.length; i++) {
			var group = groupList[i]
			if (group.id == groupId) {
				return group
				break
			}
		}
	},
	setGroupList: function(list) {
		plus.storage.setItem("groupList", JSON.stringify(list))
	},
	getGroupList: function() {
		var groupListStr = plus.storage.getItem('groupList')
		if (!this.isNotNull(groupListStr)) {
			return []
		}
		return JSON.parse(groupListStr)
	},
	removeGroupList: function() {
		plus.storage.removeItem('groupList')
	},
	isNotNull: function(str) {
		if (str != null && str !='' && str != undefined) {
			return true
		}
		return false
	}
}
