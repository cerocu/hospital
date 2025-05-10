package com.kosmo.hospital.repositories;

import com.kosmo.hospital.entity.Cita;
import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ICitaCrudRepository extends CrudRepository<Cita, Long> {
    List<Cita> findByDoctorAndConsultorioAndHorarioConsultaBetween(
            Doctor doctor,
            Consultorio consultorio,
            Date fechaInicio,
            Date fechaFin
    );

    Optional<Cita> findById(Long id);

 /*   public void addCita(Cita cita);*/
}
