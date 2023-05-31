/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Service;

import com.portfolio.vers20.Entity.Biography;
import com.portfolio.vers20.Repository.IBiographyRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EQUIPO
 */
@Service
@Transactional
public class SBiography {
    @Autowired
    IBiographyRepository ibiographyRepository;
    
    public List<Biography> list(){
        return ibiographyRepository.findAll();
    }
    
    public Optional<Biography> getOne(int id){
        return ibiographyRepository.findById(id);
    }
    
    public void save(Biography biography){
        ibiographyRepository.save(biography);
    }
    
    public void delete(int id){
        ibiographyRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return ibiographyRepository.existsById(id);
    }
    
}
