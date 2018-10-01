import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import MyInfoNavigator from '../../../navigation/MyInfoNavigator'

export default class MyInfoStack extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<MyInfoNavigator />)
    }
}