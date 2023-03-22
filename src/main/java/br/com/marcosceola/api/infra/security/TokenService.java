package br.com.marcosceola.api.infra.security;

import br.com.marcosceola.api.exception.ApiException;
import br.com.marcosceola.api.model.usuario.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;
    private static String ISSUER = "API voll.med";

    public String gerarToken(Usuario usuario) {
        try {
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(dataExpiracao())
                    .sign(criarAlgoritimo());
        } catch (JWTCreationException excepton) {
            throw new ApiException("Erro ao gerar token JWT", excepton);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String tokenJWT) {
        try {
            return JWT.require(criarAlgoritimo())
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();
        } catch (JWTVerificationException e) {
            throw new ApiException("Token inválido ou expirado");
        }
    }

    private Algorithm criarAlgoritimo() {
        return Algorithm.HMAC256(secret);
    }
}
