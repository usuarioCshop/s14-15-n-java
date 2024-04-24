import { userStore } from "@/store/userStore";
import { useState } from "react";

export const useLogin = () => {    
    const [error, setError] = useState(false)
    const [userData, setUserData] = useState({
        emailUser:'',
        password:''
      })
    const { login, logout, user } = userStore()

    const handleLogin = async (e) => {
        e.preventDefault();
        
        if(userData.emailUser.trim() === '' || userData.password.trim() === '') {
            setError(true)
            setTimeout(()=>{
              setError(false)
            },1000)
            return
        }
        await login(userData)
    }

  return {
    userData,
    error,
    handleLogin,
    logout,
    setUserData,
    user
  }
}

            // "emailUser": "admin@gmail.com",
            // "password": "admin1234"