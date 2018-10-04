import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity, Alert, Image} from 'react-native';
import { PubsubName } from '../../constant/PubsubContant'
import Icon from 'react-native-vector-icons/FontAwesome';

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

export default class UserManagement extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    goBack() {
        this.props.navigation.goBack();
    }

    quitUser() {
        Alert.alert('退出当前账号','退出后将无法收到消息通知,确定退出?',[{
            text: '取消',
            onPress: () => {
                
            }
        },{
            text: '确定',
            onPress: () => {
                
            }
        }])
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'账号管理'}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
           />
           <TouchableOpacity style={styles.info}>
            <Image style={{width: 30,height: 30,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/user/avatar/11E68E08859F3D3ED8123CA35AB08B6F.png?v=1538639216280'}}/>
             <View>
                <Text style={{fontSize: 20}}>炮塔向后转</Text>
                <Text style={{color: 'gray'}}>1246361002</Text>
             </View>
           </TouchableOpacity>
           <TouchableOpacity style={styles.nowStatus}>
               <Text>在线</Text>
               <Icon name={'check'} size={17} style={{color:'gray',marginRight: 20}} />
           </TouchableOpacity>
           <TouchableOpacity style={styles.quit}
            onPress={()=>this.quitUser()}>
               <Text>退出当前账号</Text>
               <Icon name={'check'} size={17} style={{color:'gray',marginRight: 20}} />
           </TouchableOpacity>
        </View>)
    }
}

const styles = StyleSheet.create({
    info: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 50,
        marginLeft: 20,
        marginTop: 20
    },
    nowStatus: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        height: 30,
        marginLeft: 20,
        marginTop: 30
    },
    quit: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        height: 30,
        marginLeft: 20,
        marginTop: 30
    }
});