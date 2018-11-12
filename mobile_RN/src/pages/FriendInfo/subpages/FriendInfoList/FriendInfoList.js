import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

import FriendInfoItem from '../FriendInfoItem/FriendInfoItem'

export default class FriendInfoList extends Component {

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
                    return (<FriendInfoItem settingItem={settingItem} key={index} selectItemFn={this.props.selectItemFn}/>)
                })
            }
        </View>)
    }
}