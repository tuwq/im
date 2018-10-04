import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
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
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    onPressFn(configId) {
       
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