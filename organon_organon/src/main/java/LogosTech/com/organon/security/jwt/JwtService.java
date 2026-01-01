package LogosTech.com.organon.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import LogosTech.com.organon.domain.usuario.Usuario;
import ch.qos.logback.core.pattern.parser.Parser;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtService {

    private static final String CHAVE_SECRETA =
            "minha-chave-super-secreta-com-mais-de-32-bytes";

    private static final long EXPIRACAO_MS = 1000 * 60 * 60; // 1 hora

    private Key obterChave() {
        return Keys.hmacShaKeyFor(CHAVE_SECRETA.getBytes());
    }

    // 🔑 GERAR TOKEN
    public String gerarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .claim("funcao", usuario.getFuncao())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRACAO_MS))
                .signWith(obterChave(), SignatureAlgorithm.HS256)
                .compact();
    }

    // 🔍 VALIDAR TOKEN
    public boolean tokenValido(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(obterChave())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    // 👤 EXTRAIR EMAIL
    public String extrairEmail(String token) {
        return obterClaims(token).getSubject();
    }

    public String extrairFuncao(String token) {
        return obterClaims(token).get("funcao", String.class);
    }


    private Claims obterClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(obterChave())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
