package com.med.time.service;

import com.med.time.mapper.MedicamentoMapper;
import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.MedicamentoRepository;
import com.med.time.repository.dto.MedicamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicamentoMapper medicamentoMapper;

    public MedicamentoDTO create(MedicamentoDTO medicamentoDTO) {
        return medicamentoMapper.medicamentoToDTO((medicamentoRepository.save(medicamentoMapper.toEntity(medicamentoDTO))));
    }

    public List<Medicamento>listarMedicamentos() {
        return medicamentoRepository.findAll();
    }

    public Optional<Medicamento>buscarMedicamentoPorId(Long id) {
        return medicamentoRepository.findById(id);
    }

    public void removerMedicamento(Long id) {
        medicamentoRepository.deleteById(id);
    }


}
