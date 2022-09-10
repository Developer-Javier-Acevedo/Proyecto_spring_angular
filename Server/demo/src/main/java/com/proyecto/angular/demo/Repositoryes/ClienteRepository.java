package com.proyecto.angular.demo.Repositoryes;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.angular.demo.Entity.General.ClienteEntity;


@Repository
public interface ClienteRepository extends JpaRepository <ClienteEntity, Integer> {

    @Query(value = "SELECT * FROM tb_cliente where Nombre LIKE :Nombre", nativeQuery = true) //SQL
    List<ClienteEntity> findLikeNombre(@Param("Nombre") String Nombre);

    @Query(value = "SELECT * FROM tb_cliente where Id_Identificacion =:IdentificacionCliente", nativeQuery = true) //SQL
    List<ClienteEntity> findbyIdentificacion(@Param("IdentificacionCliente") String IdentificacionCliente);

}
