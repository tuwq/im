import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import TabNavigator from 'react-native-tab-navigator';
import Icon from 'react-native-vector-icons/FontAwesome';

import Message from './../Message/Message';
import MyInfo from './../MyInfo/MyInfo';
import Docs from './../Docs/Docs';



export default class Main extends Component {

    constructor(props) {
        super(props)
        this._rendTab = this._rendTab.bind(this)
        this.state = {
            selectedTab: 'Message'
        }
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    _rendTab(Component, selectTab, title, SelectedIcon, NoSelectedIcon) {
        return (<TabNavigator.Item
            renderIcon={() => NoSelectedIcon}
            renderSelectedIcon={() => SelectedIcon}
            selectedTitleStyle={{color: '#2965F3'}}
            selected={this.state.selectedTab === selectTab}
            onPress={() => this.setState({ selectedTab: selectTab })}>
            <Component {...this.props} />
          </TabNavigator.Item>)
    }

    render() {
        return (<View style={styles.container}>
           <TabNavigator>
               {this._rendTab(Message, 'Message', 'Message', <Icon name={'comments-o'} size={24} style={{color:'#2965F3'}} />, <Icon name={'comments-o'} size={24} style={{color:'gray'}} />)}
               {this._rendTab(Docs, 'Docs', 'Docs', <Icon name={'cloud'} size={24} style={{color:'#2965F3'}} />, <Icon name={'cloud'} size={24} style={{color:'gray'}} />)}
               {this._rendTab(MyInfo, 'MyInfo', 'MyInfo', <Icon name={'th-list'} size={24} style={{color:'#2965F3'}} />, <Icon name={'th-list'} size={24} style={{color:'gray'}} />)}
           </TabNavigator>
        </View>)
    }
}

const styles = StyleSheet.create({
    container: {
      flex: 1,
    }
  });