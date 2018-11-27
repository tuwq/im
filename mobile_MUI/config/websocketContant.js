window.websocketRequestContant = {
	OpenWebsocket: 'OpenWebsocket', // 打开连接
	KeepALive: 'KeepALive',
	SingleChatSendMsg: 'SingleChatSendMsg', // 发送私聊消息
	SingleChatSendImage: 'SingleChatSendImage', // 发送私聊图片
	SingleSigningMsg: 'SingleSigningMsg', // 签收私聊消息
	GroupChatSendMsg: 'GroupChatSendMsg',
	GroupChatSendImage: 'GroupChatSendImage',
	GroupSigningMsg: 'GroupSigningMsg'
}
window.websocketResultContant = {
	AcceptSingleChatMsg: 'AcceptSingleChatMsg', // 接收私聊消息
	AcceptSingleChatImage: 'AcceptSingleChatImage', // 接收私聊图片
	AcceptGroupChatMsg: 'AcceptGroupChatMsg', // 接收群聊消息
	AcceptGroupChatImage: 'AcceptGroupChatImage', // 接收群聊图片
	PullNewContact: 'PullNewContact',		// 重新渲染通讯录
	PullNewSingleRequest: 'PullNewSingleRequest' // 重新刷新好友请求
}
