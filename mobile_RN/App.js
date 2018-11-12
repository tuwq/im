import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import AppNavigator from './src/navigation/AppNavigator'
import Toast,{DURATION} from 'react-native-easy-toast'
import PubSub from 'pubsub-js'
import { PubsubName } from './src/constant/PubsubContant'
import { Provider } from 'react-redux'
import configureStore from './src/store/configureStore'
const store = configureStore()

export default class App extends Component {
  constructor(props) {
    super(props)
    this.toastSubscribe = this.toastSubscribe.bind(this)
    PubSub.subscribe(PubsubName.toastSubscribe, this.toastSubscribe)
  }

  componentWillUnmount() {
    PubSub.unsubscribe(this.toastSubscribe)
  }

  toastSubscribe(msg, data) {
    this.toast.show(data, DURATION.LENGTH_SHORT)
  }

  render() {
    return (
      <View style={styles.container}>
        <Provider store={store}>
          <AppNavigator />
        </Provider>
        <Toast ref={toast=>this.toast=toast}/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  }
});
