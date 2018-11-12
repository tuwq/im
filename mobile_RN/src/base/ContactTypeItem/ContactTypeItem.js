import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class ContactTypeItem extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<TouchableOpacity style={styles.ContactTypeItem} 
                onPress={()=>this.props.selectItemFn(this.props.item.id)}>
            <Icon name={this.props.item.iconName} size={20} style={{color:'#000'}} />
            <Text style={styles.text}>{this.props.item.text}</Text>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    ContactTypeItem: {
        alignItems: 'center'
    },
    text: {
        marginTop: 5,
        fontSize: 15,
    }
});