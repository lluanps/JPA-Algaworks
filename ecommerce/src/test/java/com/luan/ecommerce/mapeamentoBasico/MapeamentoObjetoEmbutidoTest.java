package com.luan.ecommerce.mapeamentoBasico;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.EnderecoEntregaPedido;
import com.luan.ecommerce.model.Pedido;
import com.luan.ecommerce.model.StatusPedido;

public class MapeamentoObjetoEmbutidoTest extends EntityManagerTest {

	@Test
	public void analisarMapeamentoObjetoEmbutido() {
		Pedido pedido = new Pedido(); 

		EnderecoEntregaPedido enderecoEntregaPedido = new EnderecoEntregaPedido();
		enderecoEntregaPedido.setCep("0014586840");
		enderecoEntregaPedido.setLogradouro("Rua do java");
		enderecoEntregaPedido.setNumero("123");
		enderecoEntregaPedido.setBairro("Centro");
		enderecoEntregaPedido.setCidade("Oracle");
		enderecoEntregaPedido.setEstado("JVM");
		
		pedido.setId(1);
		pedido.setDataPedido(LocalDateTime.now());
		pedido.setStatus(StatusPedido.AGUARDANDO);
		pedido.setTotal(new BigDecimal(1000));
		pedido.setEnderecoEntrega(enderecoEntregaPedido);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pedido);
		entityManager.getTransaction().commit();
		
		entityManager.clear();
		
		Pedido pedidoVerificacao = entityManager.find(Pedido.class, pedido.getId());
		assertNotNull(pedidoVerificacao);
		assertNotNull(pedidoVerificacao.getEnderecoEntrega());
		assertNotNull(pedidoVerificacao.getEnderecoEntrega().getCep());
		
	}
	
}
