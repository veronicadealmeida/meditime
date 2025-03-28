package com.med.time.repository;


import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.dto.MedicamentoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
    }