import {login} from "../services/api";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { useAuth } from "../context/AuthContext";   

function Login(){
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [mensagem, setMensagem] = useState("");
    const navigate = useNavigate();
    const { login } = useAuth();

    async function handleSubmit(e) {
        e.preventDefault();
        try{
             await login(email, senha); //await siginifica que a função vai esperar a resposta da requisição
            navigate("/dashboard"); //redireciona para a página de dashboard após o login bem-sucedido

        }catch{
            setMensagem("Erro ao realizar login. Verifique suas credenciais.");
        }
    }
    return(
        <form onSubmit={handleSubmit}>
            <h2>Login</h2>
            <input
             type="email" 
             placeholder="Email"
             value={email}
             onChange={(e) => setEmail(e.target.value)}
             />
             <input 
             type="senha" 
             placeholder="Senha"
             value={senha}
             onChange={(e) => setSenha(e.target.value)}/>

             <button type="submit">Entrar</button>

             <p>{mensagem}</p>
        </form>
    )
}
export default Login;