package com.luan.ecommerce.jpql;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.TypedQuery;

import org.checkerframework.checker.units.qual.t;
import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;
import com.luan.ecommerce.model.Cliente;
import com.luan.ecommerce.model.Pedido;

//JPQL
public class BasicoJPQLTest  extends EntityManagerTest {
	
	@Test
	public void buscarPorIdentificador() {
		TypedQuery<Pedido> typedQuery = entityManager
				.createQuery("select p from Pedido p where p.id = 1", Pedido.class);
		
		Pedido pedido = typedQuery.getSingleResult();
		
		assertNotNull(pedido);
	}

	@Test
	public void selcionarUmAtributoParaRetorno() {
		String jpql = "select p.nome from Produto p";
		
		TypedQuery<String> typedQuery = entityManager.createQuery(jpql, String.class);
		List<String> list = typedQuery.getResultList();
		
		assertTrue(String.class.equals(list.get(0).getClass()));
		
		String jpqlCliente = "select p.cliente from Pedido p";
		TypedQuery<Cliente> typedQueryCliente = entityManager.createQuery(jpqlCliente, Cliente.class);
		List<Cliente> listCliente = typedQueryCliente.getResultList();
		
		assertTrue(Cliente.class.equals(listCliente.get(0).getClass()));
	}
	
	@Test
	public void projetarOResultado() {
//		String jpql = "select p.id, p.nome from Produto p";
		String jpql = "select id, nome from Produto";// funciona tbm
		
		TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> list = typedQuery.getResultList();
		
		assertTrue(list.get(0).length == 2);
		
		list.forEach(arr -> System.out.print(arr[0] + ", " + arr[1]));
		
	}
	
	
}
