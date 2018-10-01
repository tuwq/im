import { createStackNavigator } from 'react-navigation'
import Docs from '../pages/Docs/Docs'

export default DocsNavigator = createStackNavigator({
    Docs: {
        screen: Docs
    }
},{
    navigationOptions: {
        header: null
    }
})