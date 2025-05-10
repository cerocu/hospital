package com.kosmo.hospital.services;

import com.kosmo.hospital.repositories.Consultorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultorioService {
    @Autowired
    Consultorio consultorio;
    public List<com.kosmo.hospital.entity.Consultorio> getAllConsultorio() {

        try{
           //  List<com.kosmo.hospital.entity.Consultorio> consultorios = consultorio.findAll();
            List<com.kosmo.hospital.entity.Consultorio> consultorios = consultorio.findAll();
            System.out.println(consultorios.size());
            System.out.println(consultorios.get(0));
            return consultorios;
        }
        catch (Exception e){
            System.out.println("Error ConsultorioService"+e);
            System.out.println("Error ConsultorioService"+e.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

}
