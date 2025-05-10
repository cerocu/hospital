package com.kosmo.hospital.services;

import com.kosmo.hospital.entity.Cita;
import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import com.kosmo.hospital.repositories.ICitaCrudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {

    private final ICitaCrudRepository citaRepository;

    @Autowired
    public CitaService(ICitaCrudRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

//    public void addCita(Doctor doctor, Consultorio consultorio, Date fechaInicio,Date fechaFin, String paciente) {
    public String addCita(Cita cita, String paciente) {
        List<Cita> enConsultorio = citaRepository.findByDoctorAndConsultorioAndHorarioConsultaBetween(cita.getDoctor(), cita.getConsultorio(), cita.getHorarioConsulta(), cita.getHorarioConsulta());
        for (Cita c : enConsultorio) {
            return "Ya hay una cita en el consultorio a esa hora.";
        }


        citaRepository.save(cita);
        return "exitoso";
    }

    public List<Cita> getCitasPorDoctorConsultorioYFecha(Doctor doctor, Consultorio consultorio, Date fechaInicio, Date fechaFin) {

          try{
              return citaRepository.findByDoctorAndConsultorioAndHorarioConsultaBetween(doctor, consultorio, fechaInicio, fechaFin);
          }
        catch (Exception e){
            System.out.println("Error service");
              return new ArrayList<>();
        }
    }










    private boolean conflictoDeHorario(Cita existente, String horario) {
        return !(existente.getHorarioConsulta().equals(horario));
    }
}
