import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity} from 'react-native';

export default class BottomBar extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    render() {
        return (<View style={styles.container}>
            <View style={styles.BottomBarContainer}>
                <TouchableOpacity>
                    <Text style={styles.text}>{this.props.leftText}</Text>
                </TouchableOpacity>
                <TouchableOpacity>
                    <Text style={styles.text}>{this.props.rightText}</Text>
                </TouchableOpacity>
            </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1
    },
    BottomBarContainer: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center',
        height: 50
    },
    text: {
        margin: 10,
        color: '#2196F3'
    }
});