document.write("<script language=javascript src='../../config/TimConfig.js'></script>");
window.TimUtil = {
	/**
	 * toast弹窗
	 * @param {Object} message 信息
	 * @param {Object} type 图片类型
	 */
	showToast: function(message, type) {
		plus.nativeUI.toast(message, {icon: "../../image/"+ type + ".png", verticalAlign: "bottom"})
	},
	setSystemStatusColor: function() {
		plus.navigator.setStatusBarBackground('#16102E')
      	plus.navigator.setStatusBarStyle('light')
	},
	/**
	 * 缓存当前用户信息
	 * @param {Object} user 用户对象
	 */
	setCacheNowUserInfo: function(user) {
		var userInfoStr = JSON.stringify(user)
		plus.storage.setItem("nowUserInfo", userInfoStr)
	},
	/**
	 * 获取缓存用户信息
	 */
	getCacheNowUserInfo: function() {
		return JSON.parse(plus.storage.getItem('nowUserInfo'))
	},
	setCacheNowUserProperty: function(key, value) {
		var user = this.getCacheNowUserInfo()
		user[key] = value
		this.setCacheNowUserInfo(user)
	},
	/**
	 * 清除缓存当前用户信息
	 */
	removeCacheNowUserInfo: function() {
		plus.storage.removeItem('nowUserInfo')
	},
	/**
	 * 封装ajax-post请求
	 * @param {Object} url
	 * @param {Object} data
	 * @param {Object} success
	 * @param {Object} fail
	 */
	postJson: function(url, data, success, fail) {
		mui.ajax(window.TimConfig.serverUrl + url,{
			data: data,
			dataType:'json',
			type:'post',
			timeout:10000,
			headers:{'Content-Type':'application/json'},	              
			success:function(data){
				success(data)
			}
		});
	},
	/**
	 * 上传文件
	 * @param {Object} url
	 * @param {Object} data
	 * @param {Object} success
	 * @param {Object} fail
	 */
	postUpload: function(url, data, success, fail) {
		mui.ajax(window.TimConfig.serverUrl + url,{
			data: data,
			dataType:'json',
			type:'post',
			timeout:10000,
			headers:{'Content-Type':'multipart/form-data'},	              
			success:function(data){
				success(data)
			}
		});
	}
}
