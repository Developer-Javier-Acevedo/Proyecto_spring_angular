package com.proyecto.angular.demo.Repositoryes;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.angular.demo.Entity.General.ProductoEntity;


@Repository
public interface ProductoRepository extends JpaRepository <ProductoEntity, Integer> {

    @Query(value = "SELECT * FROM tb_producto where Serial LIKE :Serial", nativeQuery = true) //SQL
    List<ProductoEntity> findLikeSerial(@Param("Serial") String Serial);

    
}
