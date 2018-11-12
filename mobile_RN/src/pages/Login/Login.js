import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput, TouchableOpacity} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'

export default class Login extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    Login() {
        this.props.navigation.navigate(NavigatorName.Main)
    }

    goRegister() {
        this.props.navigation.navigate(NavigatorName.Register)
    }

    render() {
        return (<View style={styles.loginContainer}>
           <View style={styles.form}>
                <View style={styles.formGroup}>
                    <TextInput style={styles.formTextInput} onChangeText={accountNumber=>this.accountNumber=accountNumber} placeholder="输入账户"/>
                </View>
                <View style={styles.formGroup}>
                    <TextInput style={styles.formTextInput} onChangeText={password=>this.password=password} placeholder="输入密码"/>
                </View>
                <View style={styles.formGroup}>
                    <View style={styles.formRow}>
                        <TouchableOpacity
                            style={styles.formButton}
                            onPress={()=>this.Login()}>
                            <Text style={styles.text}>登录</Text>
                        </TouchableOpacity>
                        <TouchableOpacity
                            style={styles.formButton}
                            onPress={()=>this.goRegister()}>
                            <Text style={styles.text}>新用户注册</Text>
                        </TouchableOpacity>
                    </View>                   
                </View>
           </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    loginContainer: {
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