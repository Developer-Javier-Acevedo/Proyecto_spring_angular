package com.proyecto.angular.demo.Repositoryes.General;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.angular.demo.Entity.General.ProductoEntity;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

    @Query(value = "SELECT * FROM tb_producto where Serial LIKE :Serial", nativeQuery = true) // SQL
    List<ProductoEntity> findLikeSerial(@Param("Serial") String Serial);

    @Query(value = "SELECT * FROM tb_producto WHERE upper (Nombre) LIKE upper (:nombre) AND Estado = 1", nativeQuery = true)
    Page<ProductoEntity> findByLikeSerialPagin(Pageable pageable, @Param("nombre") String nombre);

    @Modifying
    @Query(value = "UPDATE tb_producto SET Stock = Stock - :cantidad WHERE Id_producto =:id", nativeQuery = true)
    void updataStock(@Param("id") Integer id, @Param("cantidad") Integer stock);

}
