import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import TabNavigator from 'react-native-tab-navigator';
import Icon from 'react-native-vector-icons/FontAwesome';

import Message from './../Message/Message';
import Office from './../Office/Office';
import Docs from './../Docs/Docs';



export default class Main extends Component {

    constructor(props) {
        super(props)
        this._rendTab = this._rendTab.bind(this)
        this.initSocket = this.initSocket.bind(this)
        this.initSubscribe = this.initSubscribe.bind(this)
        this.CHAT = null
        this.state = {
            selectedTab: 'Message'
        }
    }

    componentDidMount() {
        this.initSocket()
        this.initSubscribe()
    }

    componentWillUnmount() {

    }

    initSocket() {
        var self = this
        this.CHAT = {
            socket: null,
            init() {
                this.socket = new WebSocket(global.sockeUrl)
                global.socket = this.socket
                this.socket.onopen = function() {
                    console.log("连接建立成功...")
                }
                this.socket.onclose = function() {
                    console.log("连接关闭")
                }
                this.socket.onerror = function() {
                    console.log("发送错误")
                }
                this.socket.onmessage = function(e) {
                    let result = JSON.parse(e.data)
                    global.SocketFrame.tigger(result.action, result)
                }
            }
        }
        this.CHAT.init()
    }

    initSubscribe() {
        global.SocketFrame.subscribe('AR',(result)=>{
            console.log(result)
        })
        global.SocketFrame.subscribe('BR',(result)=>{
            console.log(result)
        })
        global.SocketFrame.subscribe('CR',(result)=>{
            console.log(result)
        })
        global.SocketFrame.subscribe('DR',(result)=>{
            console.log(result)
        })
    }

    _rendTab(Component, selectTab, title, SelectedIcon, NoSelectedIcon) {
        return (<TabNavigator.Item
            renderIcon={() => NoSelectedIcon}
            renderSelectedIcon={() => SelectedIcon}
            selectedTitleStyle={{color: '#2965F3'}}
            selected={this.state.selectedTab === selectTab}
            onPress={() => this.setState({ selectedTab: selectTab })}>
            <Component {...this.props} />
          </TabNavigator.Item>)
    }

    render() {
        return (<View style={styles.container}>
           <TabNavigator>
               {this._rendTab(Message, 'Message', 'Message', <Icon name={'comments-o'} size={24} style={{color:'#2965F3'}} />, <Icon name={'comments-o'} size={24} style={{color:'gray'}} />)}
               {this._rendTab(Docs, 'Docs', 'Docs', <Icon name={'cloud'} size={24} style={{color:'#2965F3'}} />, <Icon name={'cloud'} size={24} style={{color:'gray'}} />)}
               {this._rendTab(Office, 'Office', 'Office', <Icon name={'th-list'} size={24} style={{color:'#2965F3'}} />, <Icon name={'th-list'} size={24} style={{color:'gray'}} />)}
           </TabNavigator>
        </View>)
    }
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
    }
});