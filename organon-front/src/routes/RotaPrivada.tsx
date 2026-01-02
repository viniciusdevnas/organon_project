import { Navigate } from "react-router-dom";
import { useAuth } from "../context/AuthContext"; 
import { ReactNode } from "react";  

interface RotaPrivadaProps {
  children: ReactNode;
}

export function RotaPrivada({ children }: RotaPrivadaProps) {
  const { isAuthenticated, loading } = useAuth();

  if (loading) {
    return <p>Carregando...</p>;
  }

  if (!isAuthenticated) {
    return <Navigate to="/login" />;
  }

  return children;
}