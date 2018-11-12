import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';

import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'
import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class MyInfo extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    goBack() {
        
    }

    finish() {

    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                rightButton={ViewUtil.getNavigationBarTitleButton('完成',()=>{this.finish()})}
                title={this.props.navigation.state.params.navigationBarTitle}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
            <Text>{this.props.navigation.state.params.navigationBarTitle}</Text>
        </View>)
    }
}