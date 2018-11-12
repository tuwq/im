import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput, TouchableOpacity, Image} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../../../constant/PubsubContant'

export default class ContactGroupItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.ContactGroupItem}>
             <Image style={{width: 45,height: 45,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
             <Text>仟月酱</Text>
        </TouchableOpacity>)
    } 
}

const styles = StyleSheet.create({
    ContactGroupItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 30,
        marginTop: 30,
        marginLeft: 20
    }
});