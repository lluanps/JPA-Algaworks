package com.luan.ecommerce.jpql;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;

import com.luan.ecommerce.EntityManagerTest;

public class JoinTest extends EntityManagerTest {

	@Test
	public void fazerJoin() {
//		String jpql = "select p from Pedido p join p.pagamento pag where pag.status = 'PROCESSANDO'";
		String jpql = "select p from Pedido p join p.items i where i.precoProduto > 10";
		
		TypedQuery<Object[]> typedQuery = entityManager.createQuery(jpql, Object[].class);
		
		List<Object[]> list = typedQuery.getResultList();
		assertTrue(list.size() == 1);
	}
	
}
