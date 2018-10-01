import { createStackNavigator } from 'react-navigation'
import Welcome from '../pages/Welcome/Welcome'
import Main from '../pages/Main/Main'

export default AppNavigator = createStackNavigator({
    Welcome: {
        screen: Welcome,
    },
    Main: {
        screen: Main
    }
},{
    navigationOptions: {
        header: null
    }
})

