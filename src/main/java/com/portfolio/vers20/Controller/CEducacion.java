/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.vers20.Controller;

import com.portfolio.vers20.Dto.dtoEducacion;
import com.portfolio.vers20.Entity.Educacion;
import com.portfolio.vers20.Service.SEducacion;
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

/**
 *
 * @author EQUIPO
 */
@RestController
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://gasparwebservice.web.app/")
public class CEducacion {
    @Autowired
    SEducacion seducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = seducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!seducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el Id de esa Educacion"), HttpStatus.BAD_REQUEST);
        }
        Educacion educacion = seducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!seducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID NO Existe"), HttpStatus.NOT_FOUND);
        }
        seducacion.delete(id);
        return new ResponseEntity(new Mensaje("Educacion Eliminada"), HttpStatus.OK);
    }
    
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoeducacion){
        if(!seducacion.existsById(id)){
            return new ResponseEntity(new Mensaje("El ID NO Existe"), HttpStatus.NOT_FOUND);
        }
        if(StringUtils.isBlank(dtoeducacion.getTituloE())){
            return new ResponseEntity(new Mensaje("El Campo Titulo no puede estar Vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Educacion educacion = seducacion.getOne(id).get();
        educacion.setTituloE(dtoeducacion.getTituloE());
        educacion.setInstitucionE(dtoeducacion.getInstitucionE());
        educacion.setDescripcionE(dtoeducacion.getDescripcionE());
        educacion.setUrlE(dtoeducacion.getUrlE());
        
        seducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Modificacion Realizada"), HttpStatus.OK);
    }
}
