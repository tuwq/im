import { createStackNavigator } from 'react-navigation'
import Welcome from './../pages/Welcome/Welcome';

export default WelcomeNavigator = createStackNavigator({
    Welcome: {
        screen: Welcome
    }
},{
    navigationOptions: {
        header: null
    }
})