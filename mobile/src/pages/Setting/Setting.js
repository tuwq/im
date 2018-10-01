import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import { NavigatorName } from '../../constant/NavigatorContant'

export default class Setting extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<View>
           <Text>Setting: {this.props.navigation.state.params.name}</Text>
           <Button title='UserManagement' 
            onPress={()=>{
                this.props.navigation.navigate(NavigatorName.UserManagement,{
                    id: 123,
                    name: 'UserManagement'
                })
            }}/>
        </View>)
    }
}