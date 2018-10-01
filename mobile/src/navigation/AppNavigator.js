import { createStackNavigator } from 'react-navigation'
import Welcome from './../pages/Welcome/Welcome';
import Main from './../pages/Main/Main';
import ChatPrivate from './../pages/ChatPrivate/ChatPrivate';
import ChatGroup from './../pages/ChatGroup/ChatGroup';
import Contact from './../pages/Contact/Contact';
import Setting from './../pages/Setting/Setting';
import UserManagement from './../pages/UserManagement/UserManagement';

export default AppNavigator = createStackNavigator({
    Welcome: {
        screen: Welcome,
    },
    Main: {
        screen: Main
    },
    ChatPrivate: {
        screen: ChatPrivate
    },
    ChatGroup: {
        screen: ChatGroup
    },
    Contact: {
        screen: Contact
    },
    Setting: {
        screen: Setting
    },
    UserManagement: {
        screen: UserManagement
    }
},{
    navigationOptions: {
        header: null
    }
})

