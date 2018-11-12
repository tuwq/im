import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';

export default class FindAddGroupItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.findAddGroupItem}>
            <Image style={{width: 45,height: 45,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/artimg/2018/9/1536816904_1c2bcb0a6ee2b44cdaa0f6b5c25df6f8.jpg'}}/>
            <View>
                <Text style={{fontSize: 16,width: 150,color: '#000'}} ellipsizeMode="tail" numberOfLines={1}>群A1</Text>
            </View>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    findAddGroupItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 40,
        marginTop: 20,
        marginLeft: 20
    }
});