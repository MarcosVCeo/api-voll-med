package br.com.marcosceola.api.service;

import br.com.marcosceola.api.exception.ApiException;
import br.com.marcosceola.api.model.usuario.Usuario;
import br.com.marcosceola.api.model.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByLogin(String login) {
        return usuarioRepository
                .findByLogin(login)
                .orElseThrow(() -> new ApiException(String.format("Usuario %s não foi encontrado", login)));
    }

}
