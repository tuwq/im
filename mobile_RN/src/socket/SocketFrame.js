export class SocketData {
    constructor(action, msg, extendFields) {			
          this.action = action
        this.msg = msg
        this.extendFields = extendFields
    }
}

export class SocketResult {
    constructor(action, result, code) {			
      this.action = action
      this.result = result
      this.code = code
  }
}


global.SocketFrame = {
    listeners: new Map(),
    tigger(action, result) {
        global.SocketFrame.listeners.get(action)(result)
    },
    subscribe(action, callback) {
        global.SocketFrame.listeners.set(action, callback)
    },
    emit(action, data, extendFields) {
        let socketData= new SocketData(action, data, extendFields||'')
        global.socket.send(JSON.stringify(socketData))
    },
    unSubscribe(action) {
        global.SocketFrame.listeners.delete(action)
    }
}