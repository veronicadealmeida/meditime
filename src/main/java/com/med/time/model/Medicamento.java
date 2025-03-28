package com.med.time.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medicamentos")
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dosagem;
    private String hora;
    private String frequencia;
    private String enviaLembrete;
    private String usoContinuo;
    private LocalDate dataInicio;
    private LocalDate dataFim;

}