package com.med.time.service;

import com.med.time.model.Horario;
import com.med.time.model.Medicamento;
import com.med.time.model.Usuario;
import com.med.time.repository.HorarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LembreteService {

    private final HorarioRepository horarioRepository;
    private final WhatsappService whatsappService;

    private final DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

    @Scheduled(fixedRate = 15 * 60 * 1000) // a cada 15 minutos
    public void enviarLembretes() {
        log.info("Executando verificação de horários...");

        List<Horario> horarios = horarioRepository.findAll();

        LocalTime agora = LocalTime.now();
        int margemMinutos = 15;

        for (Horario horario : horarios) {
            Medicamento med = horario.getMedicamentoId();
            Usuario user = horario.getUsuarioId();

            if ("S".equalsIgnoreCase(med.getEnviaLembrete())) {
                String horaRemedio = med.getHora();
                LocalTime horaMed = LocalTime.parse(horaRemedio, horaFormatter);

                if (Math.abs(horaMed.toSecondOfDay() - agora.toSecondOfDay()) <= margemMinutos * 60) {
                    String msg = String.format("Olá %s! Está na hora de tomar seu remédio: %s (%s).",
                            user.getNome(), med.getNome(), med.getDosagem());

                    whatsappService.enviarMensagem(user.getTelefone(), msg);
                }
            }
        }
    }
}
