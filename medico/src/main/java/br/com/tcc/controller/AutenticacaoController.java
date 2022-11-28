package br.com.tcc.controller;

import br.com.tcc.config.security.TokenService;
import br.com.tcc.vo.dto.DadosLogin;
import br.com.tcc.vo.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosLogin> autenticar(@RequestBody LoginForm loginForm) {

        try {
            DadosLogin dados = tokenService.gerarToken(authManager.authenticate(loginForm.converter()));

            return ResponseEntity.ok(dados);

        } catch (AuthenticationException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(path = "validaToken/{token}")
    public ResponseEntity validaToken(@PathVariable String token) {
        boolean isValid = tokenService.isTokenValido(token);
        if(isValid) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
