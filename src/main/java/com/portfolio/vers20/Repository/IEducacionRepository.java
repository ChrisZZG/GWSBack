/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.vers20.Repository;

import com.portfolio.vers20.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EQUIPO
 */
@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Integer>{
    
    public Optional<Educacion> findByTituloE(String tituloE);
    
    public boolean existsByTituloE(String tituloE);
}
