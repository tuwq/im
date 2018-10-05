import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import ScrollableTabView, {ScrollableTabBar}  from 'react-native-scrollable-tab-view';
import Icon from 'react-native-vector-icons/FontAwesome';
import PubSub from 'pubsub-js'
import {NavigatorName} from '../../constant/NavigatorContant'

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from '../../util/ViewUtil'
import ChooseChatGroupItem from './subpages/ChooseChatGroupItem/ChooseChatGroupItem'
import MenuDialog from '../../base/MenuDialog/MenuDialog'
import ChooseGroupMenuData from '../../data/ChooseGroupMenuData.json'

export default class ChooseChatGroup extends Component {

    constructor(props) {
        super(props)
        this.openExtra = this.openExtra.bind(this)
        this.selectItemMenuFn = this.selectItemMenuFn.bind(this)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    goBack() {
        this.props.navigation.goBack();
    }

    openExtra() {
        this.refs.menuDialog.show()
    }

    selectItemMenuFn(typeId) {
        this.refs.menuDialog.hide()
        switch(typeId) {
            case "1":
                this.props.navigation.navigate(NavigatorName.Main)
                break
            case "2":
                this.props.navigation.navigate(NavigatorName.FindAddGroup)
                break
            default:
                PubSub.publish(PubsubName.toastSubscribe, '功能不可用');
                return
        }
    }

    render() {
        return (<View style={styles.container}>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(()=>this.goBack())}
                title={'群聊'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'list'} size={17} style={{color:'#fff'}} />, () => {this.openExtra()})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
           <ScrollableTabView
                tabBarBackgroundColor={global.theme.color}
                tabBarInactiveTextColor="mintcream"
                tabBarActiveTextColor="white"
                tabBarUnderlineStyle={{backgroundColor: '#e7e7e7',height: 2}}
                renderTabBar={()=><ScrollableTabBar />}
           >
            <ChooseChatGroupItem tabLabel="我的群" text="我的群"/>
            <ChooseChatGroupItem tabLabel="多人聊天" text="多人聊天"/>
           </ScrollableTabView>
           <MenuDialog ref="menuDialog" menus={ChooseGroupMenuData.menus} selectItemFn={this.selectItemMenuFn}/>
        </View>)
    }
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
    }
});