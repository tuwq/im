import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../constant/PubsubContant'

export default class MyInfo extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
           <Text>MyInfo</Text>
           <Button title='sendToApp' 
            onPress={()=>{
                PubSub.publish(PubsubName.toastSubscribe, 'MyInfo');
            }}/>
        </View>)
    }
}