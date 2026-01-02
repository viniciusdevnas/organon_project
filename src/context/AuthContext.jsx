import { createContext, useContext, useState, useEffect } from "react";
import { login as loginApi } from "../services/api";

const AuthContext = createContext(null);

export function AuthProvider({ children }) {
  const [token, setToken] = useState(null);
  const [usuario, setUsuario] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
  const tokenSalvo = localStorage.getItem("token");
  const usuarioSalvo = localStorage.getItem("usuario");

  if (tokenSalvo && usuarioSalvo) {
    try {
      setToken(tokenSalvo);
      setUsuario(JSON.parse(usuarioSalvo));
    } catch (error) {
      console.error("Usuário inválido no localStorage, limpando dados");
      localStorage.removeItem("token");
      localStorage.removeItem("usuario");
    }
  }

  setLoading(false);
}, []);


  
  async function login(email, senha) {
    const response = await loginApi(email, senha);

    const { token, usuario } = response.data;

    localStorage.setItem("token", token);
    localStorage.setItem("usuario", JSON.stringify(usuario));

    setToken(token);
    setUsuario(usuario);
  }

  function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("usuario");

    setToken(null);
    setUsuario(null);
  }

  const isAuthenticated = !!token;


  return (
    <AuthContext.Provider
      value={{
        token,
        usuario,
        login,
        logout,
        isAuthenticated,
        loading,
      }}
    >
      {children}
    </AuthContext.Provider>
  );
}

export function useAuth() {
  const context = useContext(AuthContext);

  if (!context) {
    throw new Error("useAuth deve ser usado dentro de AuthProvider");
  }

  return context;
}

