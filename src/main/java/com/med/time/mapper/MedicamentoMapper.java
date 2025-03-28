package com.med.time.mapper;

import com.med.time.model.Medicamento;
import com.med.time.repository.dto.MedicamentoDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MedicamentoMapper {

    public MedicamentoDTO medicamentoToDTO(Medicamento medicamento) {
        if (medicamento == null) {
            return null;
        }
        return new MedicamentoDTO(
                medicamento.getId(),
                medicamento.getNome(),
                medicamento.getDosagem(),
                medicamento.getHora(),
                medicamento.getFrequencia(),
                medicamento.getEnviaLembrete(),
                medicamento.getUsoContinuo(),
                medicamento.getDataInicio(),
                medicamento.getDataFim()
        );
    }

    public Medicamento medicamento = new Medicamento();

    public Medicamento toEntity(MedicamentoDTO medicamentoDTO) {

        if (medicamentoDTO.id() != null) {
            medicamento.setId(medicamentoDTO.id());
        }

        medicamento.setNome(medicamentoDTO.nome());
        medicamento.setDosagem(medicamentoDTO.dosagem());
        medicamento.setHora(medicamentoDTO.hora());
        medicamento.setFrequencia((medicamentoDTO.frequencia()));
        medicamento.setEnviaLembrete(medicamentoDTO.enviaLembrete());
        medicamento.setUsoContinuo(medicamentoDTO.usoContinuo());
        medicamento.setDataInicio(medicamentoDTO.dataInicio());
        medicamento.setDataFim(medicamentoDTO.dataFim());

        return medicamento;
    }
}
