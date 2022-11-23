package io.github.com.lafsdev.security.jwt;

import io.github.com.lafsdev.domain.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtService {

    @Value("{security.jwt.expiracao}")
    private String expiracao;
    @Value("{security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    private String gerarToken(Usuario usuario) throws ExpiredJwtException {
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);
        return Jwts.builder().setSubject(usuario.getLogin()).setExpiration(data).signWith(SignatureAlgorithm.HS512, chaveAssinatura).compact();
    }

    public boolean tokenValido(String token) {
        try {
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }

    public String obterLoginUsuario(String token) throws ExpiredJwtException {
        return (String) obterClaims(token).getSubject();
    }

    public Claims obterClaims(String token) {
        return Jwts.parser().setSigningKey(chaveAssinatura).parseClaimsJwt(token).getBody();
    }
}
