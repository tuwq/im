import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

import MyInfoItem from '../MyInfoItem/MyInfoItem'

export default class MyInfoList extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
            {
                this.props.settings.map((settingItem,index)=>{
                    return (<MyInfoItem settingItem={settingItem} key={index} selectItemFn={this.props.selectItemFn}/>)
                })
            }
        </View>)
    }
}