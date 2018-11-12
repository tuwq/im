import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity, Image} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class MessageGroupChatItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.messageGroupChatItem}>
            <Image style={{width: 45,height: 45,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1536816904_1c2bcb0a6ee2b44cdaa0f6b5c25df6f8.jpg'}}/>
            <View style={styles.message}>
            <Text style={{fontSize: 16,width: 150,color: '#000'}} ellipsizeMode="tail" numberOfLines={1}>群A1</Text>
                <Text style={{color: 'gray',width: 150}} ellipsizeMode="tail" numberOfLines={1}>仟月酱: okok,okkok</Text>
            </View>
            <View style={styles.timeContainer}>
                <Text style={{fontSize: 14,color: 'gray',alignSelf: 'flex-start'}}>2018-10-4</Text>
            </View>
        </TouchableOpacity>)
    }
}

import {
    Dimensions
}from 'react-native'
const {maxHeight, maxWidth} = Dimensions.get('window');

const styles = StyleSheet.create({
    messageGroupChatItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 80,
        marginTop: 20,
        marginLeft: 20,
    },
    message: {
        justifyContent: 'space-between',
    },
    timeContainer: {
        flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'flex-end',
        marginRight: 20
    }
});