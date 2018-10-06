import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class MyInfoItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.MyInfoItem}>
            <Text style={styles.settingKey}>{this.props.settingItem.settingKey}</Text>
            <Text style={styles.settingValue} ellipsizeMode="tail" numberOfLines={1}>炮塔向后转</Text>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    MyInfoItem: {
        height: 40,
        marginTop: 20,
        marginLeft: 20,
    },
    settingKey: {
        fontSize: 12,
        color: 'rgba(0,0,0,.2)'
    },
    settingValue: {

    }
})