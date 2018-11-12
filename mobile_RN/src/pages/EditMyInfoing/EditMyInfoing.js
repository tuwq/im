import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';

import { PubsubName } from '../../constant/PubsubContant'
import { NavigatorName } from '../../constant/NavigatorContant'
import NavigationBar from '../../base/NavigationBar/NavigationBar';
import ViewUtil from '../../util/ViewUtil';

export default class EditMyInfoing extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    goBack() {
       this.props.navigation.goBack() 
    }

    changeAvatar() {

    }

    render() {

        let settingItem = this.props.navigation.state.params.settingItem

        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={settingItem.text}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
            <View style={styles.formGroup}>
                <TextInput defaultValue={'1246361002'} textContentType="telephoneNumber" style={styles.formTextInput} onChangeText={accountNumber=>this.accountNumber=accountNumber} placeholder={'输入'+settingItem.text}/>
            </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    formGroup: {
        alignItems: 'center',
    },
    formTextInput: {
        width: 200,
        height: 60,
        borderRadius: 5,
        borderWidth: 0
    }
});