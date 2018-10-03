import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class Setting extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'设置'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <Text>Setting:</Text>
           <Button title='UserManagement' 
            onPress={()=>{
                this.props.navigation.navigate(NavigatorName.UserManagement)
            }}/>
            <Button title='MyInfo' 
            onPress={()=>{
                this.props.navigation.navigate(NavigatorName.MyInfo)
            }}/>
        </View>)
    }
}