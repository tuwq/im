import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {Modal, TouchableOpacity, StyleSheet, Image, DeviceInfo, View, Text} from 'react-native'
import Icon from 'react-native-vector-icons/FontAwesome';

export default class BottomDialog extends Component {

    constructor(props) {
        super(props)
        this.state = {
            visible: false
        }
    }

    show() {
        this.setState({
            visible: true
        })
    }

    hide() {
        this.setState({
            visible: false
        })
    }

    render() {
        return (<Modal
            transparent={true}
            visible={this.state.visible}
            onRequestClose={()=>{}}
        >
            <TouchableOpacity
                style={styles.container}
                onPress={()=>this.hide()}
            >
                <View style={styles.content}>
                    {
                        this.props.menus.map((item, index)=>{
                            return ( <TouchableOpacity
                                key={index}
                                onPress={()=>{}}
                                underlayColor={'transparent'}
                                onPress={()=>{
                                    this.props.selectItemFn(item.id)
                                }}
                            >
                                <View style={styles.item}>
                                    <Text style={styles.itemText}>{item.text}</Text>
                                </View>
                            </TouchableOpacity>)
                        })
                    }
                </View>
            </TouchableOpacity>
        </Modal>)
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: 'rgba(0,0,0,0.3)',
        alignItems: 'flex-end'
    },
    content: {
        position: 'absolute',
        left: 0,
        right: 0,
        bottom: 0,
        backgroundColor: 'white',
    },
    item: {
        height: 50,
        alignItems: 'center',
        flexDirection: 'row',
        justifyContent: 'center',
    },
    itemText: {
        fontSize: 16,
        color: '#2196F3',
        fontWeight: '400',
        paddingRight: 15,
        alignItems: 'center',
    }
});