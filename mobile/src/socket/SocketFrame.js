global.SocketFrame= {
    listeners: new Map(),
    tigger(action, result) {
        global.SocketFrame.listeners.get(action)(result)
    },
    subscribe(action, callback) {
        global.SocketFrame.listeners.set(action, callback)
    },
    emit(action, data, extendsFields) {
        console.log(action)
        console.log(data)
        console.log(extendsFields)
    }
}