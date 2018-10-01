import { createBottomTabNavigator } from 'react-navigation'
import Message from '../pages/Message/Message'
import Docs from '../pages/Docs/Docs'
import MyInfo from '../pages/MyInfo/MyInfo'

export default MainNavigator = createBottomTabNavigator({
    Message: {
        screen: Message
    },
    Docs: {
        screen: Docs
    },
    MyInfo: {
        screen: MyInfo
    }
})