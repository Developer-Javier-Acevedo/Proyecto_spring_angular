package com.proyecto.angular.demo.Repositoryes.Procesos;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.proyecto.angular.demo.Entity.procesos.PedidoDetalleEntity;

@Repository
public class PedidoDetalleRepository {

    @PersistenceContext
	private EntityManager entityManager;
	
	public void refresh(PedidoDetalleEntity pedidoDetalleEntity) {
		entityManager.refresh(pedidoDetalleEntity);
	}

    
}
