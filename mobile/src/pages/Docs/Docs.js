import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../constant/PubsubContant'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import * as showInfoActions from '../../store/actions/showInfo'


class Docs extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
            <Text>{this.props.showInfo.info}</Text>
            <Button title='sendToApp' 
            onPress={()=>{
                PubSub.publish(PubsubName.toastSubscribe, 'Docs');
            }}/>
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