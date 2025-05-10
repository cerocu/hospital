package com.kosmo.hospital.request;

import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
public class Cita {


    private int consultorio;



    private int doctor;

    private Date horarioConsulta;

    private String nombrePaciente;

    private String estadoCita;

}
