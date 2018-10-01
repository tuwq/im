import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import DocsNavigator from '../../../navigation/DocsNavigator'

export default class DocsStack extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<DocsNavigator />)
    }
}