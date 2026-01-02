import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8086" // backend Spring
});

// Interceptador para adicionar o token de autenticação em cada requisição
api.interceptors.request.use((config) => {
    const token = localStorage.getItem("token");
    if(token){
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
})

export async function login(email, senha) {
  return api.post("/auth/login", {
    email,
    senha
  });
}
export default api;