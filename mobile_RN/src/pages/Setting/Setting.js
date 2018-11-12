import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Alert} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'
import { PubsubName } from '../../constant/PubsubContant'
import PubSub from 'pubsub-js'
import SettingExtraData from '../../data/SettingExtraData.json'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import TextBackItem from '../../base/TextBackItem/TextBackItem'

export default class Setting extends Component {

    constructor(props) {
        super(props)
        this.onPressFn = this.onPressFn.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    onPressFn(configId) {
        switch(configId){
            case "1":
                this.props.navigation.navigate(NavigatorName.UserManagement);
                break;
            case "11":
                Alert.alert('你确定退出TIM?','退出后将无法收到消息通知,确定退出?',[{
                    text: '取消',
                    onPress: () => {
                        
                    }
                },{
                    text: '确定',
                    onPress: () => {
                        
                    }
                }])
                break;
            default:
               return
        }
    }

    goBack() {
        this.props.navigation.goBack();
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'设置'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <View styles={styles.settings}>
                {SettingExtraData.extras.map((item, index)=>{
                    return (<TextBackItem config={item} key={index} onPressFn={this.onPressFn}/>)
                })}
           </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    settings: {
        marginTop: 20
    }
});