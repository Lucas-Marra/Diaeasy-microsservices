package br.com.tcc.config.security;

import br.com.tcc.model.Medico;
import br.com.tcc.model.Paciente;
import br.com.tcc.repository.MedicoRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

    private TokenService tokenService;

    private MedicoRepository medicoRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, MedicoRepository medicoRepository) {
        this.tokenService = tokenService;
        this.medicoRepository = medicoRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperarToken(request);
        if(tokenService.isTokenValido(token)) {
            autenticarMedico(token);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }

        return token.substring(7);
    }

    private void autenticarMedico(String token) {
        Medico medico = medicoRepository.findById(tokenService.getIdMedico(token)).get();
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(medico, null, medico.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
