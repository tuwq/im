import React, {Component} from 'react';
import PropTypes from 'prop-types';
import {Modal, TouchableOpacity, StyleSheet, Image, DeviceInfo, View, Text} from 'react-native'
import Icon from 'react-native-vector-icons/FontAwesome';

export default class MenuDialog extends Component {

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
                                    <View style={styles.itemIcon}>
                                        <Icon name={item.iconName} size={17}  />
                                    </View>
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
        backgroundColor: 'rgba(0,0,0,0.2)',
        alignItems: 'flex-end'
    },
    content: {
        marginTop: 50,
        backgroundColor: 'white',
        borderRadius: 3,
        paddingTop: 3,
        paddingBottom: 3,
        marginRight: 3
    },
    item: {
        width: 150,
        height: 50,
        alignItems: 'center',
        flexDirection: 'row'
    },
    itemIcon: {
        color: 'gray',
        marginLeft: 20,
        marginRight: 10,
        width: 16
    },
    itemText: {
        fontSize: 16,
        color: 'black',
        fontWeight: '400',
        paddingRight: 15,
        alignItems: 'center',
    }
});