import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { StackActions,NavigationActions } from 'react-navigation'
import { NavigatorName } from '../../constant/NavigatorContant'

export default class Welcome extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        this.timer=setTimeout(()=> {
            const resetAction = StackActions.reset({
                index: 0,
                actions: [
                    NavigationActions.navigate({
                        routeName: NavigatorName.Login
                    })
                ]
            });
            this.props.navigation.dispatch(resetAction);
        }, 100);  
    }

    componentWillUnmount() {
        clearInterval(this.timer)
    }

    render() {
        return (<View>
            <Text>Welcome</Text>
        </View>)
    }
}