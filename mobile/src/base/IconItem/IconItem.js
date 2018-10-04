import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import GlobalStyles from '../../styles/GlobalStyles'

export default class IconItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.IconItem} 
                onPress={this.props.onPressFn}>
            <Icon name={this.props.item.iconName} size={20} style={{color:'gray'}} />
            <Text style={styles.text}>{this.props.item.text}</Text>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    IconItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 30,
        marginTop: 20,
        marginLeft: 20
    },
    text: {
        fontSize: 18,
        marginLeft: 10
    }
});