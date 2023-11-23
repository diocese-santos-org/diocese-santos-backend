package br.com.diocese.infrastructure.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {
    @Value("${forum.jwt.secret}")
    private String secret;

    @Value("${forum.jwt.subject}")
    private String subject;

    public String generateToken() {

        // Define uma data de expiração distante (por exemplo, 10 anos no futuro)
        Date expirationDate = new Date(System.currentTimeMillis() + 10 * 365 * 24 * 60 * 60 * 1000);


        return Jwts.builder()
                .setIssuer("API Empresa Desafio")
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }



    public boolean isTokenValido(String token) {
        try{
            String tokenExtraido = recuperarToken(token);
            if(getSubject(tokenExtraido).equals(subject))
                return true;

            return false;
        }
        catch (Exception e){
            return false;
        }
    }

    public String recuperarToken(String token) {
        if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }

    public String getSubject(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
