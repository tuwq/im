import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';
import OfficeExtraData from '../../data/OfficeExtraData.json'

import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'
import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import IconItem from './../../base/IconItem/IconItem';

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

    onPressFn() {
        PubSub.publish(PubsubName.toastSubscribe, '功能不可用');
    }

    goEditMyInfo() {
        this.props.navigation.navigate(NavigatorName.EditMyInfo)
    }

    render() {
        return (<View>
            <NavigationBar 
                title={'办公'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'gear'} size={17} style={{color:'#fff'}} />, () => {this.openSetting()})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
           <View style={styles.contentContainer}>
               <View style={styles.infoContainer}>
                   <View style={styles.info}>
                        <Text style={styles.nickname}>炮塔向后转</Text>
                        <Text style={styles.accountNumber}>1246361002</Text>
                   </View>
                   <TouchableOpacity style={styles.avatar} onPress={()=>this.goEditMyInfo()}>
                        <Image style={{width: 80,height: 80,borderRadius: 30}} source={{uri: 'http://img.twenq.com/upload/user/avatar/11E68E08859F3D3ED8123CA35AB08B6F.png?v=1538639216280'}}/>
                   </TouchableOpacity>
               </View>
               <View style={styles.extras}>
                    {OfficeExtraData.extras.map((item, index)=>{
                        return (<IconItem item={item} key={index} onPressFn={()=>this.onPressFn()}/>)
                    })}
               </View>
           </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    contentContainer: {
        marginTop: 50
    },
    extras: {

    },
    infoContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 50,
        margin: 30
    },
    info: {
        alignItems: 'center',
    },
    avatar: {
        marginLeft: 50
    },
    nickname: {
        fontSize: 30
    },
    accountNumber: {
        color: 'gray'
    }
});