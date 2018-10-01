import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { PubsubName } from '../../constant/PubsubContant'

export default class UserManagement extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
           <Text>UserManagement: {this.props.navigation.state.params.name}</Text>
        </View>)
    }
}