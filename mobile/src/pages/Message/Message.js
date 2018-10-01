import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button} from 'react-native';
import PubSub from 'pubsub-js'
import { PubsubName } from '../../constant/PubsubContant'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import * as showInfoActions from '../../store/actions/showInfo'

class Message extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
        
    }

    componentWillUnmount() {

    }

    render() {
        return (<View>
            <Text>Message</Text>
            <Button title='sendToApp' 
            onPress={()=>{
                PubSub.publish(PubsubName.toastSubscribe, 'Message');
            }}/>
            <Button title='changeRedux' 
            onPress={()=>{
               this.props.showInfoActions.save({
                   info: 'state showinfo.info'
               })
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

export default connect(mapStateToProps, mapDispatchToProps)(Message)