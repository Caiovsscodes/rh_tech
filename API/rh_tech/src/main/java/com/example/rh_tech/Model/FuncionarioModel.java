package com.example.rh_tech.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity

@Table(name = "Funcionarios")

@Getter
@Setter
@NoArgsConstructor
public class FuncionarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String nome;

    @Column(nullable = false, unique = true)
    private  String email;

    @Column(nullable = false)
    private  String senha;

    @Column(nullable = false)
    private  String CEP;

    @Column(nullable = false)
    private  String endereco;

    @Column(nullable = false)
    private  Integer numero;

    @Column(nullable = false)
    private  String bairro;

    @Column(nullable = false)
    private  String cidade;

    @Column(nullable = false)
    private  String estado;
}
