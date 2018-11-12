import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, TouchableOpacity, Image} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';

export default class Setting extends Component {

    constructor(props) {
        super(props)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {
        
    }

    render() {
        return (<TouchableOpacity style={styles.textBackItem}
                onPress={()=>this.props.onPressFn(this.props.config.id)}>
            <Text>{this.props.config.text}</Text>
            <View style={styles.right}>
                {
                    this.props.config.type==1
                    ?(<Text style={styles.text}>15279167097</Text>)
                    :this.props.config.type==2
                    ?(<Image style={{width: 30,height: 30,borderRadius: 30,marginRight: 10}} source={{uri: 'http://img.twenq.com/upload/user/avatar/11E68E08859F3D3ED8123CA35AB08B6F.png?v=1538639216280'}}/>)
                    :(<Text></Text>)
                }
                <Icon name={'chevron-right'} size={17} style={{color:'gray'}} />
            </View>
        </TouchableOpacity>)
    }
}

const styles = StyleSheet.create({
    textBackItem: {
        flexDirection: 'row',
        alignItems: 'center',
        height: 30,
        marginTop: 20,
        marginLeft: 20
    },
    right: {
        flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'flex-end',
        marginRight: 20
    },
    text: {
        marginRight: 10,
        fontSize: 12
    }
});