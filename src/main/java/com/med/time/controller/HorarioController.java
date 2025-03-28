package com.med.time.controller;

import com.med.time.model.Horario;
import com.med.time.model.Usuario;
import com.med.time.repository.dto.HorarioDTO;
import com.med.time.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/horarios")
public class HorarioController {

    @Autowired
    HorarioService horarioService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public HorarioDTO create(@RequestBody HorarioDTO horario) {
        return horarioService.create(horario);
    }

    @GetMapping
    public List<Horario> listarHorarios() {
        return horarioService.listarHorarios();
    }

    @GetMapping("/{id}")
    public Optional<Horario> listarHorarioPorId(@PathVariable Long id) {
        return horarioService.buscarHorarioPorId(id);
    }

//    @GetMapping("/horario-usuario/{usuarioId}")
//    public List<Horario> listarHorariosPorUsuario(@PathVariable Usuario usuario) {
//        return horarioService.listarHorariosPorUsuarioId(usuario);
//    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeHorario(@PathVariable Long id) {
        horarioService.removerHorario(id);
    }
}
