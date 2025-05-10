package com.kosmo.hospital.repositories;

import com.kosmo.hospital.entity.Cita;
import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class CitaRepository {
    @Autowired
    private ICitaCrudRepository citaCrudRepository;

    public List<Cita> getCitasPorDoctorConsultorioYFecha(
            Doctor doctor,
            Consultorio consultorio,
            Date fechaInicio,
            Date fechaFin
    ) {
        return citaCrudRepository.findByDoctorAndConsultorioAndHorarioConsultaBetween(
                doctor,
                consultorio,
                fechaInicio,
                fechaFin
        );
    }


}
