/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Controller;

import com.portfolio.vers20.Dto.dtoPersona;
import com.portfolio.vers20.Entity.Persona;
import com.portfolio.vers20.Service.SPersona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author EQUIPO
 */
@RestController
@RequestMapping("/persona")
//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(origins = "https://gasparwebservice.web.app/")
public class CPersona {
    @Autowired
    SPersona spersona;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list(){
        List<Persona> list = spersona.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!spersona.existsById(id)){
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Persona persona = spersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!spersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        spersona.delete(id);
        return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoPersona dtopersona){
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(spersona.existsByNombre(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("Ese Nombre Ya Existe"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = new Persona(dtopersona.getNombre(),
                                        dtopersona.getEmail(),
                                        dtopersona.getTelefono(),
                                        dtopersona.getDescripcion());
        
        spersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona Agregada Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoPersona dtopersona){
        if(!spersona.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID de la Persona no Existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtopersona.getNombre())){
            return new ResponseEntity(new Mensaje("El Nombre es Obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Persona persona = spersona.getOne(id).get();
        persona.setNombre(dtopersona.getNombre());
        persona.setEmail(dtopersona.getEmail());
        persona.setTelefono(dtopersona.getTelefono());
        persona.setDescripcion(dtopersona.getDescripcion());
        
        spersona.save(persona);
        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }
    
}
