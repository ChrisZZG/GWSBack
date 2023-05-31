/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Service;

import com.portfolio.vers20.Entity.Proyectos;
import com.portfolio.vers20.Repository.IProyectosRepository;
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
public class SProyectos {
    @Autowired
    IProyectosRepository iproyectosRepository;
    
    public List<Proyectos> list(){
        return iproyectosRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
        return iproyectosRepository.findById(id);
    }
    
    public Optional<Proyectos> getByNombreP(String nombreP){
        return iproyectosRepository.findByNombreP(nombreP);
    }
    
    public void save(Proyectos proyecto){
        iproyectosRepository.save(proyecto);
    }
    
    public void delete(int id){
        iproyectosRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iproyectosRepository.existsById(id);
    }
    
    public boolean existsById(String nombreP){
        return iproyectosRepository.existsByNombreP(nombreP);
    }
}
