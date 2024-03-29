package br.com.tcc.config.security;

import br.com.tcc.model.Medico;
import br.com.tcc.vo.dto.DadosLogin;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${medico.jwt.expiration}")
    private String expiration;

    @Value("${medico.jwt.secret}")
    private String secret;


    public DadosLogin gerarToken(Authentication authentication) {
        Medico medicoLogado = (Medico) authentication.getPrincipal();
        Date hoje = new Date();
        Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));

        String token = Jwts.builder()
                .setIssuer("API de medico")
                .setSubject(medicoLogado.getId().toString())
                .setIssuedAt(hoje)
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return DadosLogin.builder()
                .token(token)
                .id(medicoLogado.getId())
                .nome(medicoLogado.getNome())
                .tipo("medico")
                .build();
    }

    public boolean isTokenValido(String token) {
        try {
            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getIdMedico(String token) {
        return Long.parseLong(
                Jwts.parser().setSigningKey(this.secret)
                        .parseClaimsJws(token).getBody()
                        .getSubject());
    }
}
