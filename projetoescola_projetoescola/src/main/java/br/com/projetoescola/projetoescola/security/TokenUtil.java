package br.com.projetoescola.projetoescola.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

public class TokenUtil {
    
    // Chave longa obrigatória para o algoritmo HS256 nas versões novas
    private static final String SECRET_KEY_STRING = "exemploChaveJWTParaProjetoAcademicoComMaisDe32Caracteres2026";
    private static final Key SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes());
    private static final long EXPIRATION_TIME = 86400000; // 1 dia

    // Cria token JWT
    public static String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Valida token JWT
    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ADICIONE ESTE MÉTODO ABAIXO PARA RESOLVER O ERRO DA LINHA 32:
    public static String getUsernameFromToken(String token) {
        try {
            return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject(); // Recupera o "username" que salvamos no Subject
        } catch (Exception e) {
            return null;
        }
    }
}