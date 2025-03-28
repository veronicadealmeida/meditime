package com.med.time.controller;


import com.med.time.model.Usuario;
import com.med.time.repository.UsuarioRepository;
import com.med.time.repository.dto.UsuarioDTO;
import com.med.time.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    @ResponseStatus( code = HttpStatus.CREATED)
    public UsuarioDTO create(@RequestBody UsuarioDTO usuario) {

        return usuarioService.create(usuario);
    }


    @GetMapping
    public List<Usuario> listarUsuario() {
        return usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario busscarUsuarioPorId (@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);
        return usuario.orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeUsuario(@PathVariable Long id ) {
        usuarioService.removerUsuario(id);
    }
}