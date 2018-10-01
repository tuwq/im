import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import MessageNavigator from '../../../navigation/MessageNavigator'

export default class MessageStack extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<MessageNavigator />)
    }
}