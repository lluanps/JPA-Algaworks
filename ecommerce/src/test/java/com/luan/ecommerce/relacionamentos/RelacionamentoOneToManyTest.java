package com.luan.ecommerce.relacionamentos;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Cliente;
import com.luan.ecommerce.model.Pedido;
import com.luan.ecommerce.model.StatusPedido;

public class RelacionamentoOneToManyTest extends EntityManagerTest {

	@Test
	public void verificarRelacionamento() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setCliente(cliente);
		
		pedido.setTotal(BigDecimal.TEN);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Cliente clienteVerificacao  = entityManager.find(Cliente.class, cliente.getId());
		assertFalse(clienteVerificacao.getPedido().isEmpty());
	}
	
}
