import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity, TextInput} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class ViewUtil {

    static getNavigationBarTextInput(placeholderText) {
        return (<TextInput
            style={styles.textInput}
            onChangeText={keyword=>{}}
            placeholder={placeholderText}
            placeholderTextColor="#FFF"
        >    
        </TextInput>)
    }
    
    static getNavigationBarBackButton(callBack) {
        return (<TouchableOpacity
            style={{padding: 8}}
            onPress={callBack}
        >
            <Icon name={'chevron-left'} size={17} style={{color:'#fff'}} />
        </TouchableOpacity>)
    }

    static getNavigationBarTitleButton(title, callBack) {
        return (<TouchableOpacity
            style={{alignItems: 'center'}}
            onPress={callBack}
        >
            <View style={{marginRight: 10}}>
                <Text style={{fontSize: 20,color: '#fff'}}>{title}</Text>
            </View>
        </TouchableOpacity>)
    }

    static getNavigationBarLeftButton(component, callBack) {
        return (<TouchableOpacity
            style={{padding: 8}}
            onPress={callBack}
        >
            {component}
        </TouchableOpacity>)
    }

    static getNavigationBarRightButton(component, callBack) {
        return (<TouchableOpacity
            style={{padding: 8}}
            onPress={callBack}
        >
            {component}
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    textInput: {
        width: 200,
        height:(Platform.OS==='ios')?30:40,
        borderWidth: (Platform.OS==='ios')?1:0,
        borderColor: 'white',
        alignSelf: 'center',
        paddingLeft: 5,
        marginRight: 10,
        marginLeft: 5,
        borderRadius: 10,
        opacity: .7,
        color: 'white',
        backgroundColor: 'rgba(0,0,0,.1)'
    }
});