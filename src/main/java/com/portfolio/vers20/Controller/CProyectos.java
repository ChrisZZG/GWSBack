/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Controller;

import com.portfolio.vers20.Dto.dtoProyectos;
import com.portfolio.vers20.Entity.Proyectos;
import com.portfolio.vers20.Service.SProyectos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author EQUIPO
 */
@RestController
@RequestMapping("/proyectos")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://gasparwebservice.web.app/")
public class CProyectos {
    @Autowired
    SProyectos sproyectos;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = sproyectos.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!sproyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("El Id NO Existe"), HttpStatus.BAD_REQUEST);
        }
       Proyectos proyectos = sproyectos.getOne(id).get();
       return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sproyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("Lo que quieres eliminar no Existe"), HttpStatus.NOT_FOUND);
        }
        sproyectos.delete(id);
        return new ResponseEntity(new Mensaje("Eliminacion Correcta"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("El Nombre del Proyectos es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = new Proyectos(dtoproyectos.getNombreP(),
                                                    dtoproyectos.getDescripcionP());
        sproyectos.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto Creado Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, 
                                    @RequestBody dtoProyectos dtoproyectos){
        if(!sproyectos.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID solicitado NO Existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoproyectos.getNombreP())){
            return new ResponseEntity(new Mensaje("El Titulo no puede ir Vacio"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyecto = sproyectos.getOne(id).get();
        proyecto.setNombreP(dtoproyectos.getNombreP());
        proyecto.setDescripcionP(dtoproyectos.getDescripcionP());
        
        sproyectos.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
        
    }
}
