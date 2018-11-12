import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';

import NavigationBar from '../../base/NavigationBar/NavigationBar'
import ViewUtil from '../../util/ViewUtil'
import FindAddFriendItem from './subpages/FindAddFriendItem/FindAddFriendItem'


export default class FindAddFriend extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    goBack() {
        this.props.navigation.goBack();
    }

    search() {

    }

    render() {
        return (<View>
           <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                rightButton={ViewUtil.getNavigationBarTitleButton('搜索',()=>this.search())}
                titleView={ViewUtil.getNavigationBarTextInput('QQ号/昵称')}
                style={{backgroundColor: global.theme.color}}
           />
           <View>
               <FindAddFriendItem />
               <FindAddFriendItem />
               <FindAddFriendItem />
           </View>
        </View>)
    }
}