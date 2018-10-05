import { createStackNavigator } from 'react-navigation'
import Welcome from './../pages/Welcome/Welcome';
import Main from './../pages/Main/Main';
import ChatPrivate from './../pages/ChatPrivate/ChatPrivate';
import ChatGroup from './../pages/ChatGroup/ChatGroup';
import Contact from './../pages/Contact/Contact';
import Setting from './../pages/Setting/Setting';
import UserManagement from './../pages/UserManagement/UserManagement';
import Login from './../pages/Login/Login';
import Register from './../pages/Register/Register';
import MyInfo from './../pages/MyInfo/MyInfo';
import EditTextInfo from '../base/EditTextInfo/EditTextInfo'
import AddFriend from '../pages/AddFriend/AddFriend'
import FindAddFriend from '../pages/FindAddFriend/FindAddFriend'
import FindAddGroup from '../pages/FindAddGroup/FindAddGroup'

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
    MyInfo: {
        screen: MyInfo
    },
    UserManagement: {
        screen: UserManagement
    },
    Login: {
        screen: Login
    },
    Register: {
        screen: Register
    },
    EditTextInfo: {
        screen: EditTextInfo
    },
    AddFriend: {
        screen: AddFriend
    },
    FindAddFriend: {
        screen: FindAddFriend
    },
    FindAddGroup: {
        screen: FindAddGroup
    }
},{
    navigationOptions: {
        header: null
    }
})

