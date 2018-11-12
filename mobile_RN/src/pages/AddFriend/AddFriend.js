import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TextInput, TouchableOpacity} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';
import {NavigatorName} from '../../constant/NavigatorContant'

import NavigationBar from '../../base/NavigationBar/NavigationBar'
import ViewUtil from '../../util/ViewUtil'


export default class Docs extends Component {

    constructor(props) {
        super(props)
        this.state = {
            keyword: ''
        }
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    goBack() {
        this.props.navigation.goBack();
    }

    goFindResult(typeId) {
        switch(typeId) {
            case 1: 
                this.props.navigation.navigate(NavigatorName.FindAddFriend)
                break
            case 2:
                this.props.navigation.navigate(NavigatorName.FindAddGroup)
                break
            default:
                return
        }
    }

    render() {  
        let searchChooseStatus = (this.state.keyword==''||this.state.keyword==null)?{display: 'none'}:{display: 'flex'}

        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>{this.goBack()})}
                title={'添加'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
            <TextInput style={styles.searchInput} onChangeText={keyword=>this.setState({keyword: keyword})} placeholder="QQ号/昵称/手机号/群"/>
            <View style={searchChooseStatus}>
                <TouchableOpacity style={styles.item}
                    onPress={()=>this.goFindResult(1)}>
                    <Icon name={'user'} size={17} style={{color:'gray',width: 17,marginRight: 5}} />
                    <Text>找人:  {this.state.keyword}</Text>
                </TouchableOpacity>
                <TouchableOpacity style={styles.item}
                    onPress={()=>this.goFindResult(2)}>
                    <Icon name={'users'} size={17} style={{color:'gray',width: 17,marginRight: 5}} />
                    <Text>找群:  {this.state.keyword}</Text>
                </TouchableOpacity>
            </View>
        </View>)
    }
}

const styles = StyleSheet.create({
    searchInput: {
        width: 200,
        height: 60,
        borderRadius: 5,
        borderWidth: 0
    },
    item: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 30,
        marginTop: 20,
        marginLeft: 20
    }
});