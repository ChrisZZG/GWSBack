/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.vers20.Repository;

import com.portfolio.vers20.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EQUIPO
 */
@Repository
public interface IProyectosRepository extends JpaRepository<Proyectos, Integer>{
    
    public Optional<Proyectos> findByNombreP(String nombreP);
    
    public boolean existsByNombreP(String nombreP);
}
