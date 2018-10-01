import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';

export default class ChatPrivate extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
           <Text>ChatPrivate: {this.props.navigation.state.params.name}</Text>
        </View>)
    }
}