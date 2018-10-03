import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class ViewUtil {

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