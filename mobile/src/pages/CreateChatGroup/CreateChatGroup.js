import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Alert, TextInput, TouchableOpacity, Image} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'
import { PubsubName } from '../../constant/PubsubContant'
import PubSub from 'pubsub-js'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import ChangeAvatarMenuData from '../../data/ChangeAvatarMenuData.json'
import BottomDialog from '../../base/BottomDialog/BottomDialog'

export default class CreateChatGroup extends Component {

    constructor(props) {
        super(props)
        this.selectBottomMenuItemFn = this.selectBottomMenuItemFn.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    goBack() {
        this.props.navigation.goBack();
    }

    finish() {

    }

    groupAvatar() {
        this.refs.menuDialog.show()
    }

    selectBottomMenuItemFn(typeId) {
        this.refs.menuDialog.hide()
        PubSub.publish(PubsubName.toastSubscribe, typeId);
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'编辑群资料'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <View style={styles.form}>
                <TouchableOpacity style={styles.formGroup}
                    onPress={()=>this.groupAvatar()}>
                    <Image style={{width: 80,height: 80,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1536816904_1c2bcb0a6ee2b44cdaa0f6b5c25df6f8.jpg'}}/>
                </TouchableOpacity>
                <View style={styles.formGroup}>
                    <TextInput style={styles.formTextInput} onChangeText={accountNumber=>this.accountNumber=accountNumber} placeholder="填写群名称(2-32个字)"/>
                </View>
                <View style={styles.formGroup}>
                    <View style={styles.formRow}>
                        <TouchableOpacity
                            style={styles.formButton}
                            onPress={()=>this.finish()}>
                            <Text style={styles.text}>提交</Text>
                        </TouchableOpacity>
                    </View>                   
                </View>
           </View>
           <BottomDialog ref="menuDialog" menus={ChangeAvatarMenuData.menus} selectItemFn={this.selectBottomMenuItemFn}/>
        </View>)
    }
}

const styles = StyleSheet.create({
    form: {
        marginTop: 80
    },
    formGroup: {
        alignItems: 'center',
    },
    formRow: {
        width: 500,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center'
    },
    formTextInput: {
        width: 200,
        height: 60,
        borderRadius: 5,
        borderWidth: 0
    },
    formButton: {
        width: 80,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center'
    },
    text: {
        color: '#2196F3'
    }
});