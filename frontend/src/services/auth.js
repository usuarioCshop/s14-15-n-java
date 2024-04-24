const loginURL = 'https://s14-15-n-java.onrender.com/api/v1/auth/login'
const registroURL = 'https://s14-15-n-java.onrender.com/api/v1/user/create'
const userInfoURL = `https://s14-15-n-java.onrender.com/api/v1/user`
import { jwtDecode } from "jwt-decode";

export const loginUser = async(userData) => {
    const response = await fetch(loginURL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(userData),
    });
    if (!response.ok) throw new Error('Usuario o contraseña incorrectos');
    const data = await response.json();
    const decode = jwtDecode(data.token)
    const user = structuredClone(decode)
    
    return {
        token: data.token, 
        user
    };
};


export const registerUser = async (userData) => {
    const response = await fetch(registroURL, {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData),
    });
    if (!response.ok) throw new Error('Error en el Servidor');
        const result = await response.json();
        return result;
};

// const getUserData = async (email, token) => {
//     const response = await fetch(`${userInfoURL}/${email}`, {
//         method: 'GET',
//         headers: {
//             'Content-Type': 'application/json',
//             Authorization: `Bearer ${token}`
//         }
//     })
//     const result = await response.json()
//     return result // => fullName, email, role
// }
