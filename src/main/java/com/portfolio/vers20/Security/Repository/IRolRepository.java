/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.vers20.Security.Repository;

import com.portfolio.vers20.Security.Entity.Rol;
import com.portfolio.vers20.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author EQUIPO
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer>{
        Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
