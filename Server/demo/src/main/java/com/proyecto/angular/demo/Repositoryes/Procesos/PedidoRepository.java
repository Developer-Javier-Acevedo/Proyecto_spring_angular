package com.proyecto.angular.demo.Repositoryes.Procesos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.angular.demo.Entity.procesos.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Integer > {
    
}
