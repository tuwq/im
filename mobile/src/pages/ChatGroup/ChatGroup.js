import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';

export default class ChatGroup extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
           <Text>ChatGroup: {this.props.navigation.state.params.name}</Text>
        </View>)
    }
}