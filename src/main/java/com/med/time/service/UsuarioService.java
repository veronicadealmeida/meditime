package com.med.time.service;

import com.med.time.mapper.UsuarioMapper;
import com.med.time.model.Usuario;
import com.med.time.repository.UsuarioRepository;
import com.med.time.repository.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO create(UsuarioDTO usuario)  {
        return usuarioMapper.usuarioToDTO(usuarioRepository.save(usuarioMapper.toEntity(usuario)));
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarUsuarioPorId (Long id) {
        return usuarioRepository.findById(id);
    }

    public void removerUsuario( Long id) {
        usuarioRepository.deleteById(id);
    }
}
