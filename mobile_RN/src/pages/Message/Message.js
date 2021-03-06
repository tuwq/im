import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';

import { NavigatorName } from '../../constant/NavigatorContant'
import { PubsubName } from '../../constant/PubsubContant'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import * as showInfoActions from '../../store/actions/showInfo'
import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import MessagePrivateChatItem from '../../base/MessagePrivateChatItem/MessagePrivateChatItem'
import MessageGroupChatItem from '../../base/MessageGroupChatItem/MessageGroupChatItem'
import MenuDialog from '../../base/MenuDialog/MenuDialog'
import MessageMenuData from '../../data/MessageMenuData.json'


class Message extends Component {

    constructor(props) {
        super(props)
        this.openExtra = this.openExtra.bind(this)
        this.goContact = this.goContact.bind(this)
        this.selectMenuItemFn = this.selectMenuItemFn.bind(this)
        this.selectCharItemFn = this.selectCharItemFn.bind(this)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    goContact() {
        this.props.navigation.navigate(NavigatorName.Contact)
    }

    openExtra() {
        this.refs.menuDialog.show()
    }

    selectMenuItemFn(typeId) {
        this.refs.menuDialog.hide()
        switch(typeId) {
            case "1":
                this.props.navigation.navigate(NavigatorName.ChooseChatGroup)
                break
            case "2":
                this.props.navigation.navigate(NavigatorName.FindAddFriend)
                break
            case "3":
                this.props.navigation.navigate(NavigatorName.GroupInfo)
                break
            default:
                PubSub.publish(PubsubName.toastSubscribe, '功能不可用');
                return
        }
    }

    selectCharItemFn() {
        this.props.navigation.navigate(NavigatorName.ChatPrivate)
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarLeftButton(<Icon name={'user'} size={17} style={{color:'#fff'}} />,() => {this.goContact()})}
                title={'消息'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'plus'} size={17} style={{color:'#fff'}} />, () => {this.openExtra()})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
            <View>
                <MessagePrivateChatItem selectCharItemFn={this.selectCharItemFn}/>
                <MessagePrivateChatItem selectCharItemFn={this.selectCharItemFn}/>
                <MessageGroupChatItem />
                <MessageGroupChatItem />
            </View>
            <MenuDialog ref="menuDialog" menus={MessageMenuData.menus} selectItemFn={this.selectMenuItemFn}/>
        </View>)
    }
}

function mapStateToProps(state) {
    return {
        showInfo: state.showInfo,
    }
}
function mapDispatchToProps(dispatch) {
    return {
        showInfoActions: bindActionCreators(showInfoActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Message)