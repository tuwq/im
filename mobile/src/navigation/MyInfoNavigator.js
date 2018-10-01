import { createStackNavigator } from 'react-navigation'
import MyInfo from '../pages/MyInfo/MyInfo'

export default MyInfoNavigator = createStackNavigator({
    MyInfo: {
        screen: MyInfo
    }
},{
    navigationOptions: {
        header: null
    }
})