import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';

import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'
import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class Office extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    openSetting() {
        this.props.navigation.navigate(NavigatorName.Setting)
    }

    render() {
        return (<View>
            <NavigationBar 
                title={'办公'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'gear'} size={17} style={{color:'#fff'}} />, () => {this.openSetting()})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
           <Text>Office</Text>
           <Button title='sendToApp' 
            onPress={()=>{
                PubSub.publish(PubsubName.toastSubscribe, 'Office');
            }}/>
            <Button title='Setting' 
            onPress={()=>{
                this.props.navigation.navigate(NavigatorName.Setting)
            }}/>
        </View>)
    }
}