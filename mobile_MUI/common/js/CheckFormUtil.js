window.CheckFormUtil = {
	checkLoginForm: function(param) {
		if (!this.isNotNull(param.loginname)) {
			return '登录账户不允许为空'
		}
		if (!this.isNumber(param.loginname)) {
			return '登录账户必须是QQ号或手机号码'
		}
		if (!this.isNotNull(param.password)) {
			return '密码不允许为空'
		}
		return true
	},
	isNotNull: function(str) {
		if (str == null || str == '' || str == undefined) {
			return false
		}
		return true
	},
	isNumber: function (str) {
		return (/^\d+$/.test(str))
	}
}
