document.write("<script language=javascript src='../../config/TimConfig.js'></script>");
window.TimUtil = {
	showToast: function(message, type) {
		plus.nativeUI.toast(message, {icon: "../../image/"+ type + ".png", verticalAlign: "bottom"})
	},
	postJson: function(url, data, success, fail) {
		mui.ajax(window.TimConfig.serverUrl + url,{
			data: data,
			dataType:'json',//服务器返回json格式数据
			type:'post',//HTTP请求类型
			timeout:10000,//超时时间设置为10秒；
			headers:{'Content-Type':'application/json'},	              
			success:function(data){								
				success(data)
			}
		});
	}
}
