package com.med.time.repository.dto;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

public record MedicamentoDTO (Long id,
                              String nome,
                              String dosagem,
                              String hora,
                              String frequencia,
                              String enviaLembrete,
                              String usoContinuo,
                              LocalDate dataInicio,
                              LocalDate dataFim
) {
}
