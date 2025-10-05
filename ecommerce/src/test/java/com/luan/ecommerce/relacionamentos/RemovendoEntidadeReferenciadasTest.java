package com.luan.ecommerce.relacionamentos;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Pedido;

public class RemovendoEntidadeReferenciadasTest extends EntityManagerTest {

	@Test
	public void removerEntidadeRelacionada() {
		Pedido pedido = entityManager.find(Pedido.class, 1);
		
		assertFalse(pedido.getItemPedido().isEmpty());
		
		entityManager.getTransaction().begin();
		pedido.getItemPedido().forEach(i -> entityManager.remove(i));
		entityManager.remove(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, 1);
		assertNull(pedidoVerificacao);

	}
	
}
