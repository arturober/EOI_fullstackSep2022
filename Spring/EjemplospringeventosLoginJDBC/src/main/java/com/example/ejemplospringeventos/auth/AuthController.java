package com.example.ejemplospringeventos.auth;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ejemplospringeventos.auth.dto.LoginDto;
import com.example.ejemplospringeventos.auth.dto.RespuestaTokenDto;
import com.example.ejemplospringeventos.usuarios.Usuario;
import com.example.ejemplospringeventos.usuarios.UsuariosService;
import com.example.ejemplospringeventos.usuarios.dto.UsuarioInsertDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UsuariosService usuariosService;

    @PostMapping("/login")
    public RespuestaTokenDto login(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException {
        Usuario u = usuariosService.login(loginDto);
        String token = getToken(u);
        return new RespuestaTokenDto(token);
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public void registro(@RequestBody UsuarioInsertDto userDto) throws NoSuchAlgorithmException  {
        usuariosService.insert(new Usuario(userDto));
    }

    private String getToken(Usuario user) {
        Algorithm algorithm = Algorithm.HMAC256("token101");
        String token = JWT.create()
                .withIssuer("arturober")
                .withClaim("id", user.getId())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Caduca en un día
                .sign(algorithm);

        return token;
    }
}
