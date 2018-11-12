/** @format */

import {AppRegistry} from 'react-native';
import './src/socket/SocketFrame'
import './src/constant/GlobalConstant'
import './src/constant/StyleContant'
import App from './App';
import {name as appName} from './app.json';

AppRegistry.registerComponent(appName, () => App);
