package com.med.time.service;

import com.med.time.mapper.HorarioMapper;
import com.med.time.model.Horario;
import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.HorarioRepository;
import com.med.time.repository.MedicamentoRepository;
import com.med.time.repository.UsuarioRepository;
import com.med.time.repository.dto.HorarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Autowired
    private HorarioMapper horarioMapper;

    public HorarioDTO create(HorarioDTO horarioDTO) {
        Usuario usuario = usuarioRepository.findById(horarioDTO.usuarioId().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Medicamento medicamento = medicamentoRepository.findById(horarioDTO.medicamentoId().getId())
                .orElseThrow(() -> new RuntimeException("Medicamento não encontrado"));

//        Horario horario = horarioMapper.toEntity(horarioDTO);
        return horarioMapper.horarioToDTO((horarioRepository.save(horarioMapper.toEntity(horarioDTO))));

//        return horarioMapper.horarioToDTO(saved);
    }

    public Optional<Horario> buscarHorarioPorId(Long id) {
        return horarioRepository.findById(id);
    }

    public List<Horario> listarHorarios() {
        return horarioRepository.findAll();
    }

    public void removerHorario(Long id) {
        horarioRepository.deleteById(id);
    }
}
