window.TimConfig = {
	// 服务器地址
	serverUrl: 'http://192.168.1.112:7000',
	// 底部选项卡
	timFooterBarArray: [
		{
			pageId: "chatlist.html",
			pageUrl: "pages/Chatlist/chatlist.html",
			title: '消息'
		},
		{
			pageId: "contact.html",
			pageUrl: "pages/Contact/contact.html",
			title: '通讯录'
		},
		{
			pageId: "me.html",
			pageUrl: "pages/Me/me.html",
			title: '我'
		}
	],
	// 中间webview所需减少的距离(防止全屏)
	timStyle: {
		top: "44px",
		bottom: "50px"
	}
}
