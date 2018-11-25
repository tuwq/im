window.TimConfig = {
	// 服务器地址
	serverUrl: 'http://202cg57547.imwork.net:47424',
	websocketServerUrl: 'ws://202cg57547.imwork.net:40950/ws',
	// 图片服务器的地址
	serverImageUrl: 'http://tim.img.mackz.xin/',
	avatarPrefix: 'user/avatar/',
	qrCodePrefix: 'user/qrCode/',
	groupAvatarPrefix: 'group/avatar/',
	TimQrCodePrefix: 'tim_qrcode:',
	// 底部选项卡
	timFooterBarArray: [
		{
			pageId: "chatlist.html",
			pageUrl: "pages/Chatlist/chatlist.html",
			title: '消息'
		},
		{
			pageId: 'groupPage.html',
			pageUrl: "pages/GroupPage/groupPage.html",
			title: '群聊'
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
	timSubscribe: {
		refreshUserInfoSubscribe: 'refreshUserInfoSubscribe',
		refreshContactContactListSubscribe: 'refreshContactContactListSubscribe',
		refreshNewMessageSubscribe: 'refreshNewMessageSubscribe'
	},
	// 中间webview所需减少的距离(防止全屏)
	timStyle: {
		top: "0px",
		bottom: "50px"
	}
}
