package com.kosmo.hospital.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctor extends CrudRepository<com.kosmo.hospital.entity.Doctor, Long> {

    public List<com.kosmo.hospital.entity.Doctor> findAll();
}

