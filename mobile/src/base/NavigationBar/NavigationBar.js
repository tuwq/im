import React, {Component} from 'react';
import { Platform, StyleSheet, Text, View, Button, ViewPropTypes,StatusBar } from 'react-native';
import PropTypes from 'prop-types';

const StatusBarShape = {
    barStyle: PropTypes.oneOf(['light-content', 'default',]),
    hidden: PropTypes.bool,
    backgroundColor: PropTypes.string,
}

export default class NavigationBar extends Component {

    static propTypes = {
        style: ViewPropTypes.style,
        title: PropTypes.string,
        titleView: PropTypes.element,
        titleLayoutStyle:ViewPropTypes.style,
        hide: PropTypes.bool,
        leftButton: PropTypes.element,
        rightButton:  PropTypes.element,
        statusBar: PropTypes.shape(StatusBarShape),
    }
    static defaultProps = {
        statusBar: {
            barStyle: 'light-content',
            hidden: false,
        },
    }

    constructor(props) {
        super(props)
        this.state = {
            title: '',
            hide: false
        }
    }

    renderButton(component) {
        return (<View style={styles.navBarButton}>
            {component? component: null}
        </View>)
    }

    render() {
        // 是否显示statusBar
        let statusBar = !this.props.statusBar.hidden
        ?(<View style={[styles.statusBar,this.props.statusBar]}>
            <StatusBar {...this.props.statusBar} backgroundColor={global.theme.color}/>
        </View>)
        :null
        // 显示自定义的titleView还是标题文字的titleView
        let titleView = this.props.titleView
        ?this.props.titleView
        :(<Text ellipsizeMode="head" numberOfLines={1} style={styles.title}>{this.props.title}</Text>)
        
        let content = !this.props.hide
        ?(<View style={styles.navBar}>
            {this.renderButton(this.props.leftButton)}
            <View style={[styles.navBarTitleView,this.props.titleLayoutStyle]}>
                {titleView}
            </View>
            {this.renderButton(this.props.rightButton)}
        </View>)
        :null

        return (<View style={[styles.container,this.props.style]}>
           {statusBar}
           {content}
        </View>)
    }
}

const styles = StyleSheet.create({
    container: {
        backgroundColor: global.theme.color
    },
    statusBar: {
        height: 0,
        backgroundColor: global.theme.color
    },
    navBar: {
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'space-between',
        height: 50
    },
    navBarTitleView: {
        alignItems: 'center',
        justifyContent: 'center',
        position: 'absolute',
        left: 40,
        right: 40,
        top: 0,
        bottom: 0,
    },
    title: {
        fontSize: 20,
        color: '#fff',
    },
    navBarButton: {
        alignItems: 'center',
    }
})