import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../../../constant/PubsubContant'

import ContactGroupItem from '../ContactGroupItem/ContactGroupItem'
export default class ContactGroup extends Component {

    constructor(props) {
        super(props)
        this.state = {
            isShow: false
        }
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    toggleShow() {
        this.setState({
            isShow: !this.state.isShow
        })
    }

    render() {
        let groupItemStatus = this.state.isShow?{display: 'flex'}:{display: 'none'}

        return (<View style={styles.contactGroup}>
            <TouchableOpacity style={styles.groupInfo}
                onPress={()=>{this.toggleShow()}}>
                <Icon name={this.state.isShow?'chevron-down':'chevron-right'} size={15} style={{color:'gray',marginRight: 10}} />
                <Text>我的好友</Text>
                <View style={styles.rightInfo}>
                    <Text>19/86</Text>
                </View>
            </TouchableOpacity>
            <View style={groupItemStatus}>
                <ContactGroupItem />
                <ContactGroupItem />
            </View>
        </View>)
    } 
}

const styles = StyleSheet.create({
    contactGroup: {
        
    },
    groupInfo: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 30,
        marginTop: 20,
        marginLeft: 20
    },
    rightInfo: {
        flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'flex-end',
        marginRight: 20
    }
});