package com.kosmo.hospital.controllers;

import com.kosmo.hospital.entity.Cita;
import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import com.kosmo.hospital.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/citas/")
public class CitaController {

    private final CitaService citaService;

    @Autowired
    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }


    @PostMapping("generarcita")
    public ResponseEntity<String> generarcita(
           @RequestBody com.kosmo.hospital.request.Cita citarequest) {

        Cita cita=new Cita();
        cita.setEstadoCita("1");
        Consultorio consultorio=new Consultorio();
        consultorio.setConsultorioId(1L);
        cita.setConsultorio(consultorio);
        Doctor doctor=new Doctor();
        doctor.setDoctorId((long)citarequest.getDoctor());
        cita.setDoctor(doctor);
        cita.setNombrePaciente(citarequest.getNombrePaciente());

        cita.setHorarioConsulta(citarequest.getHorarioConsulta());

       citaService.addCita(cita,"");
        return ResponseEntity.ok("guardo exitoso");
    }
    @GetMapping("getcitas")
    public ResponseEntity<List<Cita>> getCitas(
            @RequestParam Long doctorId,
            @RequestParam Long consultorioId,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin) {


        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);

        Consultorio consultorio = new Consultorio();
        consultorio.setConsultorioId(consultorioId);

        List<Cita> citas = citaService.getCitasPorDoctorConsultorioYFecha(doctor, consultorio, fechaInicio, fechaFin);
        return ResponseEntity.ok(citas);
    }

}
