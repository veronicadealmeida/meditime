package com.med.time.repository.dto;

import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.UUID;
public record HorarioDTO(
        Long id,
        Usuario usuarioId,
        Medicamento medicamentoId
) {
}
