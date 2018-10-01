import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'

import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'

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
            <Button title='Setting' 
            onPress={()=>{
                this.props.navigation.navigate(NavigatorName.Setting,{
                    id: 123,
                    name: 'Setting'
                })
            }}/>
        </View>)
    }
}