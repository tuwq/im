class SocketData {
	constructor(action, accepetChatContent, extendFields) {			
	  	this.action = action
		this.accepetChatContent = accepetChatContent
		this.extendFields = extendFields
	}
}
class AccepetChatContent {
	constructor(senderId, acceptId, content, contentForByte, contentType, contentId) {			
	  	this.senderId = senderId
		this.acceptId = acceptId
		this.content = content
		this.contentForByte = contentForByte
		this.contentType = contentType
		this.contentId = contentId
	}
}

window.TimWebsocket = {
	socket: null,
	init: function(){
		if (window.WebSocket) {
			if (TimWebsocket.socket != null 
				&& TimWebsocket.socket != undefined
				&& TimWebsocket.socket.readyState == WebSocket.OPEN) {
				console.log('已连接,无需再次连接')
				return false
			}
			TimWebsocket.socket = new WebSocket(window.TimConfig.websocketServerUrl)
			TimWebsocket.socket.onopen = function() {
				var me = window.TimUtil.getCacheNowUserInfo()
				window.websocketUtil.oneOpenWebSocket(me.id)
				setInterval(function(){
					window.websocketUtil.keepALive()
				}, 30000)
				console.log("连接建立成功...")
				mui.toast("连接建立成功...")
			}
			TimWebsocket.socket.onclose = function() {
				console.log("连接关闭")
				mui.toast("连接关闭")
			}
			TimWebsocket.socket.onerror = function() {
				console.log("发送错误")
				mui.toast("发送错误")
			}
			TimWebsocket.socket.onmessage = function(e) {
				let result = JSON.parse(e.data)
				window.websocketUtil.tigger(result.action, result)
			}
		} else {
			alert('浏览器不支持websocket协议')
		}
	},
	send: function(data) {
		// console.log(data)
		if (TimWebsocket.socket != null 
			&& TimWebsocket.socket != undefined
			&& TimWebsocket.socket.readyState == WebSocket.OPEN) {
			TimWebsocket.socket.send(data)
		} else {
			// TimWebsocket.init()
			// TimWebsocket.reSend(data)
		}
	},
	reSend: function(data) {
		setTimeout(function(){
			TimWebsocket.socket.send(data)
		}, 2000)
	}
}
window.websocketUtil = {
	listeners: new Map,
	tigger(action, result) {
		let callback = websocketUtil.listeners.get(action)
		callback(result, result.accepetChatContent)
	},
	subscribe: function(action, callback) {
		websocketUtil.listeners.set(action,callback)
	},
	emit: function (action, content, extendFields) {
		let socketData = new SocketData(action, content, extendFields || '')
		window.TimWebsocket.send(JSON.stringify(socketData))
	},
	acceptTypeEnums: {
		imageType: 'image',
		textType: 'text',
		byteType: 'byte'
	},
	oneOpenWebSocket: function(senderId, extendFields) {
		let accepetChatContent = new AccepetChatContent(senderId, null, null, null, window.websocketUtil.acceptTypeEnums.textType, null)
		window.websocketUtil.emit(window.websocketRequestContant.OpenWebsocket, accepetChatContent, extendFields)
	},
	keepALive: function() {
		window.websocketUtil.emit(window.websocketRequestContant.KeepALive, null, null)
	},
	sendSingleText: function(senderId, acceptId, content, extendFields) {
		let accepetChatContent = new AccepetChatContent(senderId,acceptId,content,null,window.websocketUtil.acceptTypeEnums.textType,null)
		window.websocketUtil.emit(window.websocketRequestContant.SingleChatSendMsg, accepetChatContent, extendFields)
	},
	senderSingleImage: function(senderId, acceptId, content, extendFields) {
		let accepetChatContent = new AccepetChatContent(senderId,acceptId,content,null,window.websocketUtil.acceptTypeEnums.imageType,null)
		window.websocketUtil.emit(window.websocketRequestContant.SingleChatSendImage, accepetChatContent, extendFields)
	},
	signingSingleMsg: function(contentId, extendFields) {
		let accepetChatContent = new AccepetChatContent(null, null, null, null, window.websocketUtil.acceptTypeEnums.textType, contentId)
		window.websocketUtil.emit(window.websocketRequestContant.SingleSigningMsg, accepetChatContent, extendFields)
	},
	sendGroupText: function(senderId, groupId, content, extendFields) {
		let accepetChatContent = new AccepetChatContent(senderId,groupId,content,null,window.websocketUtil.acceptTypeEnums.textType,null)
		window.websocketUtil.emit(window.websocketRequestContant.GroupChatSendMsg, accepetChatContent, extendFields)
	},
	senderGroupImage: function(senderId, groupId, content, extendFields) {
		let accepetChatContent = new AccepetChatContent(senderId,groupId,content,null,window.websocketUtil.acceptTypeEnums.imageType,null)
		window.websocketUtil.emit(window.websocketRequestContant.GroupChatSendImage, accepetChatContent, extendFields)
	},
	groupSigningMsg: function(contentId, extendFields) {
		let accepetChatContent = new AccepetChatContent(null, null, null, null, window.websocketUtil.acceptTypeEnums.textType, contentId)
		window.websocketUtil.emit(window.websocketRequestContant.GroupSigningMsg, accepetChatContent, extendFields)
	}
}
