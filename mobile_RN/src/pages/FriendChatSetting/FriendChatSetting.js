import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Alert, Image, TouchableOpacity, ScrollView} from 'react-native';
import PubSub from 'pubsub-js'

import {NavigatorName} from '../../constant/NavigatorContant'
import NavigationBar from '../../base/NavigationBar/NavigationBar';
import ViewUtil from '../../util/ViewUtil';

export default class FriendChatSetting extends Component {

    constructor(props) {
        super(props)
        this.goFriendInfo = this.goFriendInfo.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    goFriendInfo(){
        this.props.navigation.navigate(NavigatorName.FriendInfo)
    }

    render() {
        return (<View style={{flex: 1}}>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'聊天设置'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <ScrollView>
                <TouchableOpacity style={styles.friendInfo} 
                    onPress={()=>this.goFriendInfo()}>
                        <Image style={{width: 45,height: 45,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1537245774_52323c7f138827816fb40c0186640a63.jpg'}}/>
                        <View>
                            <Text ellipsizeMode="tail" numberOfLines={1}>仟月酱</Text>
                            <Text ellipsizeMode="tail" numberOfLines={1}>个人签名</Text>
                        </View>
                </TouchableOpacity>
            </ScrollView>
            <View>
                <TouchableOpacity style={styles.removeFriend}>
                    <Text style={{color: '#fff'}}>删除好友</Text>
                </TouchableOpacity>
            </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    friendInfo: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 50,
        margin: 10
    },
    removeFriend: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: '#f57',
        height: 50
    }
});