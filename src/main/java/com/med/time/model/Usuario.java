package com.med.time.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.aop.target.HotSwappableTargetSource;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
//@SecondaryTable(name = "medicamentos", pkJoinColumns = @PrimaryKeyJoinColumn(name = "medicamento_id", referencedColumnName = "id"))
public class Usuario {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    private String nome;
    @Getter
    private String telefone;
}