import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Alert, Image, TouchableOpacity} from 'react-native';
import PubSub from 'pubsub-js'

export default class AllMember extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<TouchableOpacity style={styles.memberAll}>
                <View style={styles.memberTop}>
                    <Text>群成员</Text>
                    <Text>1人</Text>
                </View>
                <View style={styles.memberBottom}>
                    <Image style={{width: 50,height: 50,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
                    <Image style={{width: 50,height: 50,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
                    <Image style={{width: 50,height: 50,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
                    <Image style={{width: 50,height: 50,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
                </View>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    memberAll: {
        margin: 20
    },
    memberTop: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        height: 50
    },
    memberBottom: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 50
    }
});