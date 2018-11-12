import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import {NavigatorName} from '../../constant/NavigatorContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class ChatPrivate extends Component {

    constructor(props) {
        super(props)
        this.goFriendChatSetting = this.goFriendChatSetting.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    goBack() {
        this.props.navigation.goBack()
    }

    goFriendChatSetting() {
        this.props.navigation.navigate(NavigatorName.FriendInfo)
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'user'} size={17} style={{color:'#fff'}} />, () => {this.goFriendChatSetting()})}
                title={'仟月酱'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
        </View>)
    }
}