import { loginUser, registerUser } from '@/services/auth'
import { create } from 'zustand'


const getLocalStorage = (key) => {
    if(typeof window !== 'undefined'){
        return JSON.parse(window.localStorage.getItem(key))
    }
}
const setLocalStorage = (key, value) => {
    if(typeof window !== 'undefined'){
        window.localStorage.setItem(key, JSON.stringify(value))
    }
}

export const userStore = create((set, get) => ({
    user: getLocalStorage('user') || '',
    token: getLocalStorage('token') || '',
    login: async(userData) => {
        const { token, user } = await loginUser(userData)
        setLocalStorage('token', token)
        setLocalStorage('user', user)
        set({user: user, token: token})
    },
    logout: async () => {
        localStorage.clear()
        set({user:'', token:''})
        return location.replace('/')
    },
    createUser: async (userData) => {
        const result = await registerUser(userData)
        if(result){
            alert('Registrado Correctamente')
            return location.replace('/')
        } 
    },
    
}))
