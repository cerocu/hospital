package com.kosmo.hospital.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "consultorios")
@Getter
@Setter
public class Consultorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "consultorio_id")
    private Long consultorioId;

    @Column(name = "numero_consultorio", nullable = false)
    private Integer numeroConsultorio;

    @Column(name = "piso", nullable = false)
    private Integer piso;



}

