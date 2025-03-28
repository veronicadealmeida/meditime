package com.med.time.controller;

import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.MedicamentoRepository;
import com.med.time.repository.UsuarioRepository;
import com.med.time.repository.dto.MedicamentoDTO;
import com.med.time.service.MedicamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/medicamentos")
@RequiredArgsConstructor
public class MedicamentoController {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicamentoService medicamentoService;


    @PostMapping
    @ResponseStatus( code = HttpStatus.CREATED)
    public MedicamentoDTO adicionar(@RequestBody MedicamentoDTO medicamento) {
        return medicamentoService.create(medicamento);
    }


    @GetMapping

    public List<Medicamento> listarMedicamentos() {
        return  medicamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Medicamento buscarMedicamentoPorId (@PathVariable Long id) {
        Optional<Medicamento> medicamento = medicamentoService.buscarMedicamentoPorId(id);
        return medicamento.orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeMedicamento(@PathVariable Long id) {
        medicamentoService.removerMedicamento(id);
    }

}