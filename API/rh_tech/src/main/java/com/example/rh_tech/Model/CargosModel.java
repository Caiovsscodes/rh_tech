package com.example.rh_tech.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "Cargos")

@Getter
@Setter
@NoArgsConstructor
public class CargosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Cargo;

    @Column(nullable = false)
    private String nome_Cargo;

    @Column(nullable = false)
    private String descricao;
}
