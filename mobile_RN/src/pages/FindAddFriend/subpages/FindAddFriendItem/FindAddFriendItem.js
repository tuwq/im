import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Image, TouchableOpacity} from 'react-native';

export default class FindAddFriendItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.findAddFriendItem}>
            <Image style={{width: 40,height: 40,borderRadius: 30}} source={{uri: 'http://img.twenq.com/upload/user/avatar/11E68E08859F3D3ED8123CA35AB08B6F.png?v=1538639216280'}}/>
            <View>
                <Text style={{fontSize: 16,width: 150,color: '#000'}} ellipsizeMode="tail" numberOfLines={1}>1(1246361002)</Text>
            </View>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    findAddFriendItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 40,
        marginTop: 20,
        marginLeft: 20
    }
});