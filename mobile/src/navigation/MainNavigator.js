import { createBottomTabNavigator } from 'react-navigation'
import MessageStack from '../stack/Main/subStack/MessageStack'
import DocsStack from '../stack/Main/subStack/DocsStack'
import MyInfoStack from '../stack/Main/subStack/MyInfoStack'

export default MainNavigator = createBottomTabNavigator({
    MessageStack: {
        screen: MessageStack
    },
    DocsStack: {
        screen: DocsStack
    },
    MyInfoStack: {
        screen: MyInfoStack
    }
})