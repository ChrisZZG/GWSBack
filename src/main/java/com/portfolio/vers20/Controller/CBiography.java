/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Controller;

import com.portfolio.vers20.Dto.dtoBiography;
import com.portfolio.vers20.Entity.Biography;
import com.portfolio.vers20.Service.SBiography;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
/**
 *
 * @author EQUIPO
 */
@RestController
@RequestMapping("/biography")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://gasparwebservice.web.app/")
public class CBiography {
    @Autowired
    SBiography sbiography;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Biography>> list(){
        List<Biography> list = sbiography.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Biography> getById(@PathVariable("id") int id){
        Biography biography = sbiography.getOne(id).get();
        return new ResponseEntity(biography, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sbiography.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID de la Biografia no Existe"), HttpStatus.NOT_FOUND);
        }
        sbiography.delete(id);
        return new ResponseEntity(new Mensaje("Biografia Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoBiography dtobiography){
         if(StringUtils.isBlank(dtobiography.getParrafo())){
             return new ResponseEntity(new Mensaje("El texto del parrafo es obligatorio"), HttpStatus.BAD_REQUEST);
         }
         Biography biography = new Biography(dtobiography.getParrafo());
         sbiography.save(biography);
         return new ResponseEntity(new Mensaje("Parrafo Creado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoBiography dtobiography){
        if(!sbiography.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtobiography.getParrafo())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        Biography biography = sbiography.getOne(id).get();
        biography.setParrafo(dtobiography.getParrafo());
        sbiography.save(biography);
        
        return new ResponseEntity(new Mensaje("Parrafo Actualizado"), HttpStatus.OK);
        
    }
}
