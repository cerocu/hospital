package com.kosmo.hospital.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doctores")
@Getter
@Setter
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "apellido_materno", nullable = false)
    private String apellidoMaterno;


    @Column(name = "apellido_paterno", nullable = false)
    private String apellidoPaterno;


    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "nombre", nullable = false)
    private String nombre;




}
