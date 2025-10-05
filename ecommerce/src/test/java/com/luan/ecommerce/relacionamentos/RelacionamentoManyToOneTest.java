package com.luan.ecommerce.relacionamentos;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Cliente;
import com.luan.ecommerce.model.ItemPedido;
import com.luan.ecommerce.model.Pedido;
import com.luan.ecommerce.model.Produto;
import com.luan.ecommerce.model.StatusPedido;

public class RelacionamentoManyToOneTest extends EntityManagerTest {

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
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		assertNotNull(pedidoVerificacao.getCliente());
	}
	
	@Test
	public void verificarRelacionamentoItemPedido() {
		Cliente cliente = entityManager.find(Cliente.class, 1);
		Produto produto = entityManager.find(Produto.class, 1);
		
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(BigDecimal.TEN);
		
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setPedido(pedido);
		itemPedido.setPrecoProduto(BigDecimal.TEN);
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(1);
		
		entityManager.getTransaction().begin();
		entityManager.persist(itemPedido);
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		ItemPedido itemPedidoVerificacao = entityManager.find(ItemPedido.class, itemPedido.getId());
		assertNotNull(itemPedidoVerificacao.getPedido());
		assertNotNull(itemPedidoVerificacao.getProduto());
	}
	
}
