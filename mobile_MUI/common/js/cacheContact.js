window.cacheContact = {
	/**
	 * 从通讯录缓存中寻找目标
	 * @param {Object} userId
	 */
	getSingleContactItem: function(userId) {
		var self = this
		var contactList = self.getContactList()
		for (var i = 0; i < contactList.length; i++) {
			var user = contactList[i]
			if (user.userId == userId) {
				return user
				break
			}
		}
	},
	setContactList: function(list) {
		plus.storage.setItem("contactList", JSON.stringify(list))
	},
	getContactList: function() {
		var contactListStr = plus.storage.getItem('contactList')
		if (!this.isNotNull(contactListStr)) {
			return []
		}
		return JSON.parse(contactListStr)
	},
	removeCacheContactList: function() {
		plus.storage.removeItem('contactList')
	},
	isNotNull: function(str) {
		if (str != null && str !='' && str != undefined) {
			return true
		}
		return false
	}
}
