import api from "./api";

export async function signup(email, senha){
    const response = await api.post("/auth/login", {
        email,
        senha
    });
    localStorage.setItem("token", response.data.token);
}

export async function logout(){
    localStorage.removeItem("token");
}

export function isAuthenticated(){
    return !!localStorage.getItem("token");
}