package com.kosmo.hospital.services;

import com.kosmo.hospital.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    com.kosmo.hospital.repositories.IDoctor doctorRepository;

    public List<Doctor> getAllDoctor() {

        try{
            List<Doctor> doctors = doctorRepository.findAll();
            System.out.println(doctors.size());
            System.out.println(doctors);
            return doctors;
        }
        catch (Exception e){
            System.out.println("Error DoctorService"+e);
            return new ArrayList<>();
        }
    }
}
