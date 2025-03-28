package com.med.time.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id") // Especifica a coluna de chave estrangeira
    private Usuario usuarioId;

    @ManyToOne
    @JoinColumn(name = "medicamento_id") // Especifica a coluna de chave estrangeira
    private Medicamento medicamentoId;

}
