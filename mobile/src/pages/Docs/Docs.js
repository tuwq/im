import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';

import { PubsubName } from '../../constant/PubsubContant'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import * as showInfoActions from '../../store/actions/showInfo'
import { allApi } from './../../api/Test/test';
import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';

class Docs extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    async httpTest() {
        let result = await allApi()
        console.log(result)
    }

    render() {
        return (<View>
            <NavigationBar 
                leftButton={ViewUtil.getNavigationBarLeftButton(<Icon name={'briefcase'} size={17} style={{color:'#fff'}} />,() => {})}
                title={'云文件'}
                rightButton={ViewUtil.getNavigationBarRightButton(<Icon name={'plus'} size={17} style={{color:'#fff'}} />, () => {})}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: global.theme.color}}
            />
            <Text>功能不可用</Text>
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

export default connect(mapStateToProps, mapDispatchToProps)(Docs)