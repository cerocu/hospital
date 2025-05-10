package com.kosmo.hospital.controllers;

import com.kosmo.hospital.entity.Cita;
import com.kosmo.hospital.entity.Consultorio;
import com.kosmo.hospital.entity.Doctor;
import com.kosmo.hospital.services.CitaService;
import com.kosmo.hospital.services.ConsultorioService;
import com.kosmo.hospital.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/citas")

public class vistaController {


    @Autowired
    private  CitaService citaService;
    @Autowired
    private ConsultorioService consultorioService;
    @Autowired
    private DoctorService doctorService;


    @GetMapping("/index")
    public String mostrarConsulta(
                                 // @RequfechaFinestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fechaInicio,
                                  //@RequestParam(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date ,
                                  @RequestParam(required = false)  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fechaInicio,
                                  @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date fechaFin,
                                  @RequestParam(required = false) Long consultorioId,
                                  @RequestParam(required = false) Long doctorId,
                                  Model model) {
        Doctor doctor = new Doctor();
        doctor.setDoctorId(doctorId);

        Consultorio consultorio = new Consultorio();
        consultorio.setConsultorioId(consultorioId);
        try{
            System.out.println("consultorioId: "+ consultorioId);
            System.out.println("doctorId: "+ doctorId);
            System.out.println("fecha: "+ fechaInicio);

            List<Cita> citas = citaService.getCitasPorDoctorConsultorioYFecha(doctor, consultorio, fechaInicio, fechaFin);

           model.addAttribute("citas", citas);
        }
        catch(Exception e){
            System.out.println("error"+e);
            return "hospital";
        }
        return "hospital";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregar(
            @RequestParam(required = false) String pacienteNombre,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date horario,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long consultorioId,
            Model model) {
        model.addAttribute("doctores", doctorService.getAllDoctor());
        model.addAttribute("consultorios", consultorioService.getAllConsultorio());
        return "agregarCita";
    }

    @PostMapping("/registrar")
    public String registrar(
            @RequestParam(required = false) String pacienteNombre,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date horario,
            @RequestParam(required = false) Long doctorId,
            @RequestParam(required = false) Long consultorioId,
            Model model) {

        Cita cita=new Cita();
        cita.setEstadoCita("1");
        Consultorio consultorio=new Consultorio();
        consultorio.setConsultorioId(consultorioId);
        cita.setConsultorio(consultorio);
        Doctor doctor=new Doctor();
        doctor.setDoctorId(doctorId);
        cita.setDoctor(doctor);
        cita.setNombrePaciente(pacienteNombre);

        cita.setHorarioConsulta(horario);
        citaService.addCita(cita,"");
        return "redirect:/citas/index";
    }
}
