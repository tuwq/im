import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';

export default class ChatPrivate extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
           <Text>ChatPrivate: {this.props.navigation.state.params.name}</Text>
           <Button title='A' 
            onPress={()=>{
                global.SocketFrame.emit('A','aaa','111')
            }}/>
            <Button title='B' 
            onPress={()=>{
                global.SocketFrame.emit('B','bbb','222')
            }}/>
            <Button title='C' 
            onPress={()=>{
                global.SocketFrame.emit('C','ccc')
            }}/>
            <Button title='D' 
            onPress={()=>{
                global.SocketFrame.emit('D','ddd')
            }}/>
        </View>)
    }
}