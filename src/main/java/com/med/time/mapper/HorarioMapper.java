package com.med.time.mapper;

import com.med.time.model.Horario;
import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.dto.HorarioDTO;
import com.med.time.repository.MedicamentoRepository;
import com.med.time.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HorarioMapper {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public HorarioDTO horarioToDTO(Horario horario) {
        return new HorarioDTO(
                horario.getId(),
                horario.getUsuarioId() != null ? horario.getUsuarioId() : null,  // Adicionando apenas o ID do usuario
                horario.getMedicamentoId() != null ? horario.getMedicamentoId() : null  // Adicionando apenas o ID do medicamento
        );
    }

    public Horario toEntity(HorarioDTO dto) {
        if (dto == null) {
            return null;
        }

        Horario horario = new Horario();
        horario.setId(dto.id());

        // Buscar a instância completa de Usuario e Medicamento a partir do ID
        Usuario usuario = usuarioRepository.findById(dto.usuarioId().getId()).orElse(null);
        Medicamento medicamento = medicamentoRepository.findById(dto.medicamentoId().getId()).orElse(null);

        // Definindo as entidades completas no Horario
        horario.setUsuarioId(usuario);
        horario.setMedicamentoId(medicamento);

        return horario;
    }
}
