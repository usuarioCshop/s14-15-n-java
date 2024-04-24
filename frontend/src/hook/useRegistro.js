import { userStore } from '@/store/userStore'
import React, {useState} from 'react'

export const useRegistro = () => {
    const [newUser, setNewUser] = useState({
        fullName:'',
        email:'',
        password:'',
        password2:'',
        role: ''
    })

    const { createUser } = userStore()

    const [error, setError] = useState({
        state: false,
        msg: ''
    })

    const handleRegistro = async (e) => {
        e.preventDefault();
        const {fullName, email, password, password2, role} = newUser

        if(fullName.trim() == '' || email.trim() == '' || password.trim() == '' || role.trim() == ''){
            setError({state:true, msg: 'Todos los campos son obligatorios'})
            setTimeout(()=>{setError({state:false, msg:''})},1000)
            return
        }
        if(password !== password2){
            setError({state:true, msg: 'Deben coincidir las contraseñas'})
            setTimeout(()=>{setError({state:false, msg:''})},1000)
            return
        }
        const user = {
            fullName,
            email,
            password,
            role
        }
        await createUser(user)
        setNewUser({
            fullName:'',
            email:'',
            password:'',
            password2:'',
            role:''
        })
    }
    const handleChange = (e) => {
        if(!e.target) return setNewUser({...newUser, role: e})
        setNewUser({
            ...newUser,
            [e.target.name]:e.target.value
        })
    }

  return {
    error,
    setNewUser,
    newUser,
    handleRegistro,
    handleChange
  }
}
