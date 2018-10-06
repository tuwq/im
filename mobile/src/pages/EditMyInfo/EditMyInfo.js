import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View, Button, Dimensions, Image, ListView, PixelRatio, TouchableOpacity} from 'react-native';
import PubSub from 'pubsub-js'
import Icon from 'react-native-vector-icons/FontAwesome';
import ParallaxScrollView from 'react-native-parallax-scroll-view';

import NavigationBar from './../../base/NavigationBar/NavigationBar';
import ViewUtil from './../../util/ViewUtil';
import MyInfoList from './subpages/MyInfoList/MyInfoList'
import EditMyInfoData from '../../data/EditMyInfoData.json'

export default class EditMyInfo extends Component {

    
    constructor(props) {
        super(props)
        this._renderParallaxConfig = this._renderParallaxConfig.bind(this)
    }

    componentDidMount() {
       
    }

    componentWillUnmount() {

    }

    goBack() {
      this.props.navigation.goBack();
    }

    changeAvatar() {

    }

    _renderParallaxConfig(params) {
        let config = {}
        config.renderBackground = () => (
            <View key="background">
              <Image source={{uri:  params.backgroundImg,
                              width: window.width,
                              height: PARALLAX_HEADER_HEIGHT}}/>
              <View style={{position: 'absolute',
                            top: 0,
                            width: window.width,
                            backgroundColor: 'rgba(0,0,0,.4)',
                            height: PARALLAX_HEADER_HEIGHT}}/>
            </View>
        )
        config.renderForeground = () => (
            <View key="parallax-header" style={ styles.parallaxHeader }>
              <Image style={ styles.avatar } source={{
                uri: 'https://pbs.twimg.com/profile_images/2694242404/5b0619220a92d391534b0cd89bf5adc1_400x400.jpeg',
                width: AVATAR_SIZE,
                height: AVATAR_SIZE
              }}/>
              <Text style={ styles.sectionSpeakerText }>
                {params.name}
              </Text>
              <Text style={ styles.sectionTitleText }>
                {params.description}
              </Text>
            </View>
        )
        config.renderStickyHeader = () => (
            <View key="sticky-header" style={styles.stickySection}>
              <Text style={styles.stickySectionText}>{params.title}</Text>
            </View>
        )

        config.renderFixedHeader = () => (
            <View key="fixed-header" style={styles.fixedSection}>
              <NavigationBar 
                leftButton={ViewUtil.getNavigationBarBackButton(() => this.goBack())}
                rightButton={ViewUtil.getNavigationBarRightButton(<Text style={{color: '#fff'}}>更换头像</Text>,()=>this.changeAvatar())}
                titleLayoutStyle={{paddingRight: 10}}
                style={{backgroundColor: 'transparent'}}
            />
            </View>
        )
        
        return config
    }

    render() {
        let renderConfig = this._renderParallaxConfig({
          'name': '炮塔向后转',
          'description': '',
          'avatar': '',
          'title': '个人资料',
          'backgroundImg': 'http://img.twenq.com/upload/artimg/2018/9/1536377718_3820bd5a4a04cb806198482a52df82ad.jpg'
        })
        return (
              <ParallaxScrollView
                headerBackgroundColor="#333"
                stickyHeaderHeight={ STICKY_HEADER_HEIGHT }
                parallaxHeaderHeight={ PARALLAX_HEADER_HEIGHT }
                backgroundSpeed={10}
                {...renderConfig}>
              <MyInfoList settings={EditMyInfoData.settings}/>
            </ParallaxScrollView>
        );
    }
}


const window = Dimensions.get('window');

const AVATAR_SIZE = 120;
const ROW_HEIGHT = 60;
const PARALLAX_HEADER_HEIGHT = 350;
const STICKY_HEADER_HEIGHT = 70;

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'black'
  },
  background: {
    position: 'absolute',
    top: 0,
    left: 0,
    width: window.width,
    height: PARALLAX_HEADER_HEIGHT
  },
  stickySection: {
    height: STICKY_HEADER_HEIGHT,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: 'transparent'
  },
  stickySectionText: {
    color: 'white',
    fontSize: 20,
    margin: 10
  },
  fixedSection: {
    position: 'absolute',
    bottom: 0,
    right: 0,
    left: 0,
    top: 10,
    paddingRight: 0,

  },
  fixedSectionText: {
    color: '#999',
    fontSize: 20
  },
  parallaxHeader: {
    alignItems: 'center',
    flex: 1,
    flexDirection: 'column',
    paddingTop: 100
  },
  avatar: {
    marginBottom: 10,
    borderRadius: AVATAR_SIZE / 2
  },
  sectionSpeakerText: {
    color: 'white',
    fontSize: 24,
    paddingVertical: 5
  },
  sectionTitleText: {
    color: 'white',
    fontSize: 18,
    paddingVertical: 5
  },
  row: {
    overflow: 'hidden',
    paddingHorizontal: 10,
    height: ROW_HEIGHT,
    backgroundColor: 'white',
    borderColor: '#ccc',
    borderBottomWidth: 1,
    justifyContent: 'center'
  },
  rowText: {
    fontSize: 20
  }
});
