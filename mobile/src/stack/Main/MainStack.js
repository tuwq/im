import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import MainNavigator from '../../navigation/MainNavigator'
import PubSub from 'pubsub-js'
import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'


export default class MainStack extends Component {

    constructor(props) {
        super(props)
        this.openChatSubscribe = this.openChatSubscribe.bind(this)
        PubSub.subscribe(PubsubName.openChatSubscribe, this.openChatSubscribe)
    }

    componentWillUnmount() {
        PubSub.unsubscribe(this.openChatSubscribe)
    }

    openChatSubscribe(msg, data) {
        this.props.navigation.navigate(NavigatorName.Chat, data)
    }

    render() {
        return (<MainNavigator />)
    }
}