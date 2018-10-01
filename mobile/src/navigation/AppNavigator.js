import { createStackNavigator } from 'react-navigation'
import WelcomeStack from '../stack/Welcome/WelcomeStack'
import MainStack from '../stack/Main/MainStack'
import Welcome from './../pages/Welcome/Welcome';

export default AppNavigator = createStackNavigator({
    Welcome: {
        screen: Welcome,
    },
    MainStack: {
        screen: MainStack
    }
},{
    navigationOptions: {
        header: null
    }
})

