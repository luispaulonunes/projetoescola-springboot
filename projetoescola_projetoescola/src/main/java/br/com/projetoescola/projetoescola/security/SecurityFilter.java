package br.com.projetoescola.projetoescola.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.replace("Bearer ", "").trim();

            // 1. Valida se o Token JWT é íntegro e não expirou
            if (TokenUtil.validateToken(token)) {
                
                // 2. Extrai o nome do usuário/assunto de dentro do Token
                String username = TokenUtil.getUsernameFromToken(token);
                
                if (username != null) {
                    // 3. Cria o objeto de autenticação do Spring (sem roles/autorizações por enquanto)
                    UsernamePasswordAuthenticationToken authentication = 
                        new UsernamePasswordAuthenticationToken(username, null, Collections.emptyList());
                    
                    // 4. Injeta o usuário autenticado no contexto do Spring Security
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } else {
                // Se o token falhar na validação, avisa no console do Eclipse para facilitar o debug
                System.out.println("Filtro interceptou: Token inválido ou expirado.");
            }
        }

        // Continua o fluxo normal da requisição pelas regras do Spring Security
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        AntPathMatcher pathMatcher = new AntPathMatcher();
        
        // CORREÇÃO: O filtro só DEVE ser ignorado no LOGIN (POST) e no CADASTRO (POST).
        // Usando o padrão correto do AntPathMatcher para não matar rotas com ID como /usuarios/1
        return pathMatcher.match("/usuarios/login", path) || 
               pathMatcher.match("/usuarios/login/", path) ||
               (pathMatcher.match("/usuarios", path) && request.getMethod().equalsIgnoreCase("POST")) ||
               (pathMatcher.match("/usuarios/", path) && request.getMethod().equalsIgnoreCase("POST"));
    }
}