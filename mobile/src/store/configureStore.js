import { createStore,applyMiddleware } from 'redux'
import rootReducer from './reducers/index.js'

export default function configureStore(initialState) {
    const store = createStore(rootReducer, initialState)
    return store
}