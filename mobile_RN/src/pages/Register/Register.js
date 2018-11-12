import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput, TouchableOpacity} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class Register extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    Register() {
        this.props.navigation.navigate(NavigatorName.Main)
    }

    goBack() {
        this.props.navigation.goBack();
    }

    render() {
        return (<View style={styles.registContainer}>
           <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'注册账号'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <View style={styles.form}>
                <View style={styles.formGroup}>
                    <TextInput style={styles.formTextInput} onChangeText={accountNumber=>this.accountNumber=accountNumber} placeholder="输入账号"/>
                </View>
                <View style={styles.formGroup}>
                    <TextInput style={styles.formTextInput} onChangeText={password=>this.password=password} placeholder="输入密码"/>
                </View>
                <View style={styles.formGroup}>
                    <TouchableOpacity
                        style={styles.formButton}
                        onPress={()=>this.Register()}>
                        <Text>注册</Text>
                    </TouchableOpacity>
                </View>
           </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    registContainer: {
        position: 'relative',
        flex: 1
    },
    form: {
        flex: 1,
        marginTop: 120
    },
    formGroup: {
        alignItems: 'center',
    },
    formTextInput: {
        width: 200,
        height: 60,
        borderRadius: 5,
        borderWidth: 0
    },
    formButton: {
        width: 50,
        height: 50,
        alignItems: 'center',
        justifyContent: 'center'
    }
});