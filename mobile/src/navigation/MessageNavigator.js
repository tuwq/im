import { createStackNavigator } from 'react-navigation'
import Message from '../pages/Message/Message'

export default MessageNavigator = createStackNavigator({
    Message: {
        screen: Message
    }
},{
    navigationOptions: {
        header: null
    }
})