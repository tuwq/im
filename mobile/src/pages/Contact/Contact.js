import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../constant/PubsubContant'
import {NavigatorName} from '../../constant/NavigatorContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import ContactTypeItem from '../../base/ContactTypeItem/ContactTypeItem'
import ContactTypeData from '../../data/ContactTypeData.json'
import ContactGroup from './subpages/ContactGroup/ContactGroup'

export default class Contact extends Component {

    constructor(props) {
        super(props)
        this.selectItemFn = this.selectItemFn.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    selectItemFn(typeId) {
        switch(typeId) {
            case "1":
                break
            case "2":
                this.props.navigation.navigate(NavigatorName.ChooseChatGroup)
                break
            case "3":
                break
            default:
                return
        }
    }

    goAddFriend() {
        this.props.navigation.navigate(NavigatorName.AddFriend)
    }

    goBack() {
        this.props.navigation.goBack()
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarLeftButton(<Text style={{color: '#fff'}}>添加</Text>,() => {this.goAddFriend()})}
                title={'联系人'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon style={{color: '#fff'}} name={'chevron-right'} size={17} />, () => {this.goBack()})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
            <TextInput style={styles.formTextInput} onChangeText={keyword=>this.keyword=keyword} placeholder="搜索"/>
            <View style={styles.contactTypeContainer}>
                {
                    ContactTypeData.contactTypes.map((item,index)=>{
                        return (<ContactTypeItem item={item} key={index} selectItemFn={this.selectItemFn}/>)
                    })
                }
            </View>
            <View>
                <ContactGroup />
            </View>
        </View>)
    } 
}

const styles = StyleSheet.create({
    formTextInput: {
        width: 200,
        height: 60,
        borderRadius: 5,
        borderWidth: 0
    },
    contactTypeContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-around',
        height: 50
    }
});