import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import MainNavigator from '../../navigation/MainNavigator'


export default class MainStack extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<MainNavigator />)
    }
}