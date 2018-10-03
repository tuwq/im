import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity, Alert} from 'react-native';
import { PubsubName } from '../../constant/PubsubContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class UserManagement extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    quitUser() {
        Alert.alert('退出当前账号','退出后将无法收到消息通知,确定退出?',[{
            text: '取消',
            onPress: () => {
                
            }
        },{
            text: '确定',
            onPress: () => {
                
            }
        }])
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'用户管理'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <Text>UserManagement:</Text>
           <TouchableOpacity
            style={{alignItems: 'center'}}
            onPress={()=>this.quitUser()}
        >
            <View style={{marginRight: 10}}>
                <Text style={{fontSize: 20,color: '#fff'}}>退出账号</Text>
            </View>
        </TouchableOpacity>
        </View>)
    }
}