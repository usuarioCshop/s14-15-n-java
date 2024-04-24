import { userStore } from "@/store/userStore"

// export const checkRole = (role) => {
//     const { user } = userStore()

//     if(role == user.role){
//         return true
//     }else{
//         return false
//     }

// }
export function checkAuth(role){
    if(typeof window !== "undefined"){
        const user = JSON.parse(localStorage.getItem('user'))
        if(user && user.role == role){ 
            return true
        }else{
            return false
        }
    }
}